package com.rootCodeLabs.gdpgrowth.entity;

import javax.persistence.*;

@Entity
@Table(name = "gdp_by_year")
@IdClass(GDPByYearId.class)
public class GDPByYear {
    @Id
    @Column
    private String countryCode;

    @Id
    @Column
    private Integer year;

    @Column
    private Double gdpValue;

    public GDPByYear(String countryCode, Integer year, Double gdpValue) {
        this.countryCode = countryCode;
        this.year = year;
        this.gdpValue = gdpValue;
    }

    public GDPByYear() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(Double gdpValue) {
        this.gdpValue = gdpValue;
    }
}
