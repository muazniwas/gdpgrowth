package com.rootCodeLabs.gdpgrowth.model;

public class GDPGrowthRequest {
    private String countryCode;

    private Integer fromYear;

    private Integer toYear;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getFromYear() {
        return fromYear;
    }

    public void setFromYear(Integer fromYear) {
        this.fromYear = fromYear;
    }

    public Integer getToYear() {
        return toYear;
    }

    public void setToYear(Integer toYear) {
        this.toYear = toYear;
    }

    public GDPGrowthRequest(String countryCode, Integer fromYear, Integer toYear) {
        this.countryCode = countryCode;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }
}
