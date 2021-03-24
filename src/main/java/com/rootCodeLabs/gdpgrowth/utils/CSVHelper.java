package com.rootCodeLabs.gdpgrowth.utils;

import com.rootCodeLabs.gdpgrowth.entity.GDPByYear;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERS = { "Country Code", "Year", "Value" };

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
    public static List<GDPByYear> csvToGDPByYears(InputStream is) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(bufferedReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<GDPByYear> gdpByYears = new ArrayList<GDPByYear>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                GDPByYear gdpByYear = new GDPByYear(
                        csvRecord.get("Country Code"),
                        Integer.parseInt(csvRecord.get("Year")),
                        Double.parseDouble(csvRecord.get("Value"))
                );
                gdpByYears.add(gdpByYear);
            }

            return gdpByYears;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
