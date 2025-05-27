package com.interview.ipgeolocalizer.service;

import com.interview.ipgeolocalizer.exceptions.InvalidIp;
import com.interview.ipgeolocalizer.model.GeoLocalizedIp;
import com.interview.ipgeolocalizer.model.IpConsultResponse;
import com.interview.ipgeolocalizer.repository.IpGeolocalizationClient;
import com.interview.ipgeolocalizer.utils.AverageDistanceExporter;
import com.interview.ipgeolocalizer.utils.MaximumDistanceExporter;
import com.interview.ipgeolocalizer.utils.MinimumDistanceExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CityService {
    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    public static final double RADIO_TIERRA_KM = 6371.0;
    public static final double latitudBsAs = -34.6158;
    public static final double longitudBsAs= -58.4333;
    private final IpGeolocalizationClient ipGeolocalizationClient;
    private final MinimumDistanceExporter minimumDistanceExporter;
    private final MaximumDistanceExporter maximumDistanceExporter;
    private final AverageDistanceExporter averageDistanceExporter;
    private int count=1;

    @Autowired
    public CityService(
                       IpGeolocalizationClient ipGeolocalizationClient,
                       MinimumDistanceExporter minimumDistanceExporter,
                       MaximumDistanceExporter maximumDistanceExporter,
                       AverageDistanceExporter averageDistanceExporter) {
        this.ipGeolocalizationClient=ipGeolocalizationClient;
        this.minimumDistanceExporter = minimumDistanceExporter;
        this.maximumDistanceExporter = maximumDistanceExporter;
        this.averageDistanceExporter = averageDistanceExporter;
    }

    public IpConsultResponse consult(String ip) throws InvalidIp{
        logger.info("starting consult method for ip: "+ip);
        double latitude;
        double longitude;
        //llamar feign y obtener coordenadas
      GeoLocalizedIp geoLocalizedIp= ipGeolocalizationClient.getLocalization(ip);
       if (geoLocalizedIp.getLocation().getLatitude()!=null){
          latitude= Double.parseDouble(geoLocalizedIp.getLocation().getLatitude());
       }else{throw new InvalidIp("invalid ip: "+ip);}
       if (geoLocalizedIp.getLocation().getLongitude()!=null){
           longitude= Double.parseDouble(geoLocalizedIp.getLocation().getLatitude());
       }else{throw new InvalidIp("invalid ip "+ip);}

        //calcular distancia a buenos aires - haversine
        double distance=calcularDistanciaABsAs(latitude,longitude);
        //si es distancia mas cercana setear gauge_cercano
        if(count==1){
            minimumDistanceExporter.setDistance(Math.round(distance));
            maximumDistanceExporter.setDistance(Math.round(distance));
        }else {
            if (Math.round(distance) < minimumDistanceExporter.getDistance().doubleValue()) {
                minimumDistanceExporter.setDistance(Math.round(distance));
            }
            //si es distancia mas lejana setear gauge_lejano
            if (Math.round(distance) > maximumDistanceExporter.getDistance().doubleValue()) {
                maximumDistanceExporter.setDistance(Math.round(distance));
            }
        }
        //calcular promedio de distancias acumuladas (usar contador de visitas) y setear promedio
        averageDistanceExporter.setDistance(calculateAverageDistance(Math.round(distance)));
        count++;
        IpConsultResponse ipConsultResponse=new IpConsultResponse(
                geoLocalizedIp.getLocation().getCountry().getName(),
                geoLocalizedIp.getLocation().getCountry().getCode(),
                geoLocalizedIp.getTime_zone().getCurrent_time()+"-"+geoLocalizedIp.getTime_zone().getAbbreviation(),
                geoLocalizedIp.getCurrency().getCode(),
                geoLocalizedIp.getLocation().getLanguage().getName()+" ("+geoLocalizedIp.getLocation().getLanguage().getCode()+")",
                "Local datetime "+ LocalDateTime.now(),
                Math.round(distance)

        );
         return ipConsultResponse;
    }

    public static double calcularDistanciaABsAs(double lat2, double lon2) {
        // Convertir de grados a radianes
        double lat1Rad = Math.toRadians(latitudBsAs);
        double lon1Rad = Math.toRadians(longitudBsAs);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Diferencias
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Fórmula de Haversine
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Distancia final en kilómetros
        return RADIO_TIERRA_KM * c; }

    public long calculateAverageDistance(long distance){
        return (averageDistanceExporter.getDistance().get()*(count-1)+distance)/count;
    }

}
