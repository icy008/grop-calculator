package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.application.entity.AllData;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;


@Endpoint
@BrowserCallable
@AnonymousAllowed
public class QueryEnpoint {
    
    @Autowired
    private QueryData queryData;

    public List<AllData> getAllData() {
    return  queryData.getAllData() ;
    }
}