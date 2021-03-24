package com.rootCodeLabs.gdpgrowth.controller;

import com.rootCodeLabs.gdpgrowth.exception.ValidationException;
import com.rootCodeLabs.gdpgrowth.model.ResponseMessage;
import com.rootCodeLabs.gdpgrowth.service.GDPByYearService;
import com.rootCodeLabs.gdpgrowth.utils.CSVHelper;
import com.rootCodeLabs.gdpgrowth.model.GDPGrowthRequest;
import com.rootCodeLabs.gdpgrowth.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Cacheable(value="gdpGrowth")
@RequestMapping("/api")
public class GDPByYearController {
    @Autowired
    GDPByYearService gdpByYearService;

    @GetMapping("/gdp-growth")
    public ResponseEntity getGdpGrowth(@RequestBody GDPGrowthRequest gdpGrowthRequest) {
        Validate validate = new Validate();
        if(!validate.growthRequest(gdpGrowthRequest)) {
            throw new ValidationException("Invalid Request");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(gdpByYearService.getGdpGrowth(gdpGrowthRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("No Content Found"));
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> importGDPDataSet(@RequestParam("file")MultipartFile file) {
        String message = "";

        if(CSVHelper.hasCSVFormat(file)) {
            try {
                gdpByYearService.save(file);
                message = "Uploaded file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        } else {
            message = "Please upload a csv file!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }
}
