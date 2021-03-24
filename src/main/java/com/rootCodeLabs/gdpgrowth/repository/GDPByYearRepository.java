package com.rootCodeLabs.gdpgrowth.repository;

import com.rootCodeLabs.gdpgrowth.entity.GDPByYear;
import com.rootCodeLabs.gdpgrowth.entity.GDPByYearId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GDPByYearRepository extends JpaRepository<GDPByYear, GDPByYearId> {
    GDPByYear findByCountryCodeAndYear(String countryCode, Integer year);
}
