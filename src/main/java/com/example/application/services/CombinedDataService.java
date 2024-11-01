package com.example.application.services;

import java.util.List;
import com.example.application.entity.CombinedData;
import com.example.application.repository.CombinedDataRepository;

public class CombinedDataService  {
        private final CombinedDataRepository combinedDataRepository;


    public CombinedDataService(CombinedDataRepository combinedDataRepository) {
        this.combinedDataRepository = combinedDataRepository;
    }

    public List<CombinedData> getAllCombinedData() {
        return combinedDataRepository.findAllCombinedData();
    }
}
