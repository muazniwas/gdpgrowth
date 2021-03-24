package com.rootCodeLabs.gdpgrowth.model;

public class GDPGrowthResponse {
    private String country;

    private String countryCode;

    private Double gdpGrowthRate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getGdpGrowthRate() {
        return gdpGrowthRate;
    }

    public void setGdpGrowthRate(Double gdpGrowthRate) {
        this.gdpGrowthRate = gdpGrowthRate;
    }
}
