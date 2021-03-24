package com.rootCodeLabs.gdpgrowth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_code")
public class CountryCodeMapping {
    @Column
    private String countryName;

    @Column
    private String alphaTwoCode;

    @Id
    @Column
    private String alphaThreeCode;

    @Column
    private Integer numericCode;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public String getAlphaThreeCode() {
        return alphaThreeCode;
    }

    public void setAlphaThreeCode(String alphaThreeCode) {
        this.alphaThreeCode = alphaThreeCode;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }
}
