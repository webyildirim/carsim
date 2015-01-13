package com.carsim.core.repo;


import java.util.Collection;

import com.carsim.core.model.entities.UnitGroup;

/**
 * Created by webyildirim.
 */
public interface UnitGroupRepo {


    public UnitGroup findUnitGroup(Long id) ;

    public UnitGroup deleteUnitGroup(Long id) throws Exception;

    public UnitGroup updateUnitGroup(Long id, UnitGroup entity) throws Exception;
    
    public UnitGroup createUnitGroup(UnitGroup entity) throws Exception;

    public Collection<UnitGroup> findByName(String code);
    
}
