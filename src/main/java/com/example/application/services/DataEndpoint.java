package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.utils.TableInterface;
import com.example.application.repository.TableRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;


@BrowserCallable
@AnonymousAllowed
@Service
public class DataEndpoint {

    @Autowired
    private TableRepository tableRepository;

    public List<TableInterface> getAllDatas() {
        return  tableRepository.getCombinedDatas();
    }
}