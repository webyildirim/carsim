package com.carsim.core.repo;


import java.util.Collection;

import com.carsim.core.model.entities.Unit;

/**
 * Created by webyildirim.
 */
public interface UnitRepo {


    public Unit findUnit(Long id) ;

    public Unit deleteUnit(Long id) throws Exception;

    public Unit updateUnit(Long id, Unit entity) throws Exception;
    
    public Unit createUnit(Unit entity) throws Exception;

    public Collection<Unit> findByCode(String code);
    
    public Collection<Unit> findByUnitGroup(Long unitGroupId);
    
}
