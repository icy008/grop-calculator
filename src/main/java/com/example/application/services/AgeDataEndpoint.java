package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.Age;
import com.example.application.repository.AgeRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;


@Endpoint
@BrowserCallable
@AnonymousAllowed
@Service
public class AgeDataEndpoint {
    
    @Autowired
    private AgeRepository ageRepository;

    public List<Age> getAgeData() {
        return ageRepository.findAll();
    }
}
