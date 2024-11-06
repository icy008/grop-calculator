package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.utils.CombinedDataProjection;
import com.example.application.repository.SomeEntityRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;


@Endpoint
@BrowserCallable
@AnonymousAllowed
@Service
public class DataServiceEndpoint {

    @Autowired
    private SomeEntityRepository someEntityRepository;

    public List<CombinedDataProjection> getCombinedData() {
        return someEntityRepository.getCombinedDatas();
    }
}