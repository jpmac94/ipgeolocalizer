package com.interview.ipgeolocalizer.model;

import java.util.Map;

public class ContizationsFixer {

    private boolean success;
    private String base;
    private String date;
    private Map<String, Double> rates;

    public ContizationsFixer(boolean success, String base, String date, Map<String, Double> rates) {
        this.success = success;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
