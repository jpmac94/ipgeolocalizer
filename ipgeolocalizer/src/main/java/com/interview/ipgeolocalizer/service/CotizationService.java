package com.interview.ipgeolocalizer.service;

import com.interview.ipgeolocalizer.exceptions.NotFoundException;
import com.interview.ipgeolocalizer.model.Cotization;
import com.interview.ipgeolocalizer.repository.CotizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class CotizationService {

    private CotizationRepository cotizationRepository;

    @Autowired
    public CotizationService(CotizationRepository cotizationRepository) {
        this.cotizationRepository = cotizationRepository;
    }

    public void saveCotization(Cotization cotization){
    cotizationRepository.save(cotization);
    }

    public Cotization getCotizationById(String id) throws NotFoundException {
        return cotizationRepository.findById(id).orElseThrow(()->new NotFoundException("cotization not available"));
    }
}
