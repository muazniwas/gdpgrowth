package com.rootCodeLabs.gdpgrowth.validation;

import com.rootCodeLabs.gdpgrowth.model.GDPGrowthRequest;

public class Validate {
    public Boolean growthRequest(GDPGrowthRequest gdpGrowthRequest) {
        return gdpGrowthRequest.getCountryCode() != null
                && gdpGrowthRequest.getFromYear() != null
                && gdpGrowthRequest.getToYear()!=null;
    }
}
