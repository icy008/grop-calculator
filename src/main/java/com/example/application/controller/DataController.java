package com.example.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.interfaces.CombinedDataProjectionInterface;
import com.example.application.services.DataServiceEndpoint;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;


@Endpoint
@BrowserCallable
@AnonymousAllowed
@RestController
public class DataController {

    @Autowired
    private DataServiceEndpoint dataServiceEndpoint;

    @GetMapping("/dataServiceEndpoint")
    public List<CombinedDataProjectionInterface> getCombinedData() {

        return  dataServiceEndpoint.getCombinedData();
    }
    
}
