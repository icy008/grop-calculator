package com.example.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.application.entity.CombinedData;
import com.example.application.repository.CombinedDataRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CombinedDataController {
        @Autowired
    private CombinedDataRepository combinedDataRepository;

    @GetMapping("/api/combined-data")
    public List<CombinedData> getCombinedData() {
        return combinedDataRepository.findAllCombinedData();
    }
}
