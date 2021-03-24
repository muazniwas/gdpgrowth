package com.rootCodeLabs.gdpgrowth.repository;

import com.rootCodeLabs.gdpgrowth.entity.CountryCodeMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodeMappingRepository extends JpaRepository<CountryCodeMapping, String> {
    CountryCodeMapping findByAlphaThreeCode(String alphaThreeCode);

    CountryCodeMapping findByAlphaTwoCode(String alphaTwoCode);
}
