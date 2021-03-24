package com.rootCodeLabs.gdpgrowth.entity;

import java.io.Serializable;
import java.util.Objects;

public class GDPByYearId implements Serializable {
    private String countryCode;

    private Integer year;

    public GDPByYearId(String countryCode, Integer year) {
        this.countryCode = countryCode;
        this.year = year;
    }

    public GDPByYearId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GDPByYearId that = (GDPByYearId) o;
        return countryCode.equals(that.countryCode) &&
                year.equals(that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, year);
    }
}
