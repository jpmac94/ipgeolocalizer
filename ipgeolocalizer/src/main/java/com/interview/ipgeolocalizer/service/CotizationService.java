package com.interview.ipgeolocalizer.service;

import com.interview.ipgeolocalizer.exceptions.NotFoundException;
import com.interview.ipgeolocalizer.model.ContizationsFixer;
import com.interview.ipgeolocalizer.model.Cotization;
import com.interview.ipgeolocalizer.repository.CotizationClient;
import com.interview.ipgeolocalizer.repository.CotizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CotizationService {

    private boolean isUpdated=false;
    private String date;
    private double usd;

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    private CotizationRepository cotizationRepository;

    private CotizationClient cotizationClient;

    @Autowired
    public CotizationService(CotizationRepository cotizationRepository,
                             CotizationClient cotizationClient) {
        this.cotizationRepository = cotizationRepository;
        this.cotizationClient=cotizationClient;
    }

    public Cotization getCurrentCotization(String code) throws NotFoundException{
        if (!isUpdated){
           return getCotizationFromApi(code);
        } else if(LocalDate.now().isBefore(LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).plusDays(1))){
            return new Cotization(code,getCotizationById(code).getCotization()/usd);
        }else {
            isUpdated=false;
           return getCotizationFromApi(code);
        }
    }

    private Cotization getCotizationFromApi(String code){
        ContizationsFixer contizationsFixer=cotizationClient.getCotizations();
        contizationsFixer.getRates().forEach(
                (s,d)->saveCotization(new Cotization(s,d.doubleValue()))
        );
        date=contizationsFixer.getDate();
        usd=contizationsFixer.getRates().get("USD").doubleValue();
        isUpdated=true;
        return new Cotization(code,contizationsFixer.getRates().get(code)/usd);
    }

    private void saveCotization(Cotization cotization){
    cotizationRepository.save(cotization);
    }

    private Cotization getCotizationById(String id) throws NotFoundException {
        return cotizationRepository.findById(id).orElseThrow(()->new NotFoundException("cotization not available"));
    }
}
