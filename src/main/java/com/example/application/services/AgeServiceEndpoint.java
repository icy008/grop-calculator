package com.example.application.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.Age;
import com.example.application.repository.AgeRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;

import java.util.List;

@Endpoint
@BrowserCallable
@Service
@AnonymousAllowed
public class AgeServiceEndpoint {

    @Autowired
    private AgeRepository ageRepository;

    public List<Age> getAgeData() {
        return ageRepository.findAll();
    }
}
