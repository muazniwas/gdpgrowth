package com.rootCodeLabs.gdpgrowth.service;

import com.rootCodeLabs.gdpgrowth.entity.CountryCodeMapping;
import com.rootCodeLabs.gdpgrowth.entity.GDPByYear;
import com.rootCodeLabs.gdpgrowth.exception.ValidationException;
import com.rootCodeLabs.gdpgrowth.repository.CountryCodeMappingRepository;
import com.rootCodeLabs.gdpgrowth.repository.GDPByYearRepository;
import com.rootCodeLabs.gdpgrowth.utils.CSVHelper;
import com.rootCodeLabs.gdpgrowth.model.GDPGrowthRequest;
import com.rootCodeLabs.gdpgrowth.model.GDPGrowthResponse;
import com.rootCodeLabs.gdpgrowth.utils.Calculator;
import com.rootCodeLabs.gdpgrowth.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GDPByYearService {
    @Autowired
    GDPByYearRepository gdpByYearRepository;

    @Autowired
    CountryCodeMappingRepository countryCodeMappingRepository;

    public void save(MultipartFile file) {
        try {
            List<GDPByYear> gdpByYears = CSVHelper.csvToGDPByYears(file.getInputStream());
            gdpByYearRepository.saveAll(gdpByYears);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<GDPByYear> getAllGdpByYears() {
        return gdpByYearRepository.findAll();
    }

    public GDPGrowthResponse getGdpGrowth(GDPGrowthRequest gdpGrowthRequest) {
        if(gdpGrowthRequest.getCountryCode().length() == 2) {
            CountryCodeMapping countryCodeMapping = countryCodeMappingRepository.findByAlphaTwoCode(gdpGrowthRequest.getCountryCode());
            gdpGrowthRequest.setCountryCode(countryCodeMapping.getAlphaThreeCode());
        }
        return calculateGdpGrowth(gdpGrowthRequest);
    }

    private GDPGrowthResponse calculateGdpGrowth(GDPGrowthRequest gdpGrowthRequest) {
        GDPGrowthResponse gdpGrowthResponse = new GDPGrowthResponse();
        Calculator calculator = new Calculator();
        GDPByYear gdpByYearFrom = gdpByYearRepository.findByCountryCodeAndYear(gdpGrowthRequest.getCountryCode(), gdpGrowthRequest.getFromYear());
        GDPByYear gdpByYearTo = gdpByYearRepository.findByCountryCodeAndYear(gdpGrowthRequest.getCountryCode(), gdpGrowthRequest.getToYear());
        CountryCodeMapping countryCodeMapping = countryCodeMappingRepository.findByAlphaThreeCode(gdpGrowthRequest.getCountryCode());

        gdpGrowthResponse.setCountry(countryCodeMapping.getCountryName());
        gdpGrowthResponse.setCountryCode(gdpGrowthRequest.getCountryCode());
        gdpGrowthResponse.setGdpGrowthRate(calculator.GDPGrowth(gdpByYearFrom.getGdpValue(), gdpByYearTo.getGdpValue()));

        return gdpGrowthResponse;
    }
}
