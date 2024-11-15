package com.example.application.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.application.utils.TableInterface;
import com.example.application.repository.TableRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;


@Endpoint
@BrowserCallable
@AnonymousAllowed
@Service
public class DataServiceEndpoint {

    @Autowired
    private TableRepository tableRepository;


    public List<Map<String, Object>> getAllData() {
        List<TableInterface> query = tableRepository.getCombinedDatas();
        
        Map<String, Map<String, Object>> categoriesMap = new HashMap<>();
        
        for (TableInterface data : query) {
            String sourceTable = data.getSourceTable();
            
            Map<String, Object> category = categoriesMap.computeIfAbsent(sourceTable, k -> {
                Map<String, Object> newCategory = new HashMap<>();
                newCategory.put("title", sourceTable);
                newCategory.put("data", new ArrayList<Map<String, String>>());
                return newCategory;
            });

            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("label", data.getLabel());
            dataMap.put("value", String.valueOf(data.getValue()));
  
            @SuppressWarnings("unchecked")
            List<Map<String, String>> dataList = (List<Map<String, String>>) category.get("data");
            dataList.add(dataMap);
        }
        List<String> orderedTitles = List.of("age", "gender" , "barthel_index", "history_hf", "sbp_admission", "hemoglobin", "albumin", "bun", "bnp", "sodium","ace_arm_use");

        List<Map<String, Object>> result = new ArrayList<>(categoriesMap.values());

        result.sort(Comparator.comparing(category -> orderedTitles.indexOf(category.get("title"))));

        
        
        System.out.println(result);

        return result;
    }

}