package com.example.productcatalogserviceproxy.dto;


public class RatingDTO {

    private Double rate;
    private Long count;

    // Getters
    public Double getRate() {
        return rate;
    }

    public Long getCount() {
        return count;
    }

    // Setters
    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    // toString Method
    @Override
    public String toString() {
        return "RatingDTO{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }
}

