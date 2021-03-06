package com.carsim.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.Route;
import com.carsim.core.repo.RouteRepo;
import com.carsim.core.services.RouteService;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepo entryRepo;

    @Override
    public Route findRoute(Long id) {
        return entryRepo.findRoute(id);
    }

    @Override
    public Route deleteRoute(Long id) throws Exception {
        return entryRepo.deleteRoute(id);
    }

    @Override
    public Route updateRoute(Long id, Route entity) throws Exception {
        return entryRepo.updateRoute(id, entity);
    }
}
