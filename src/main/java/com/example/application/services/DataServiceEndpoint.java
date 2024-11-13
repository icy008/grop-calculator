package com.example.application.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.application.constant.TableInterface;
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

    public List<TableInterface> getAllData() {
        // return tableRepository.getCombinedDatas();
        List<TableInterface> query = tableRepository.getCombinedDatas();
        System.out.println("data"+query);
          return query;

    }
}