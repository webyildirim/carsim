package com.carsim.core.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.structure.BaseEntity;


@Entity
public class UnitGroup extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(targetEntity = Unit.class, mappedBy="unitGroup", fetch = (FetchType.LAZY), cascade = { CascadeType.ALL })
    private Collection<Unit> units;

    public static String WEIGHT = "WEIGHT";
    public static String COUNTABLE = "COUNTABLE";
    public static String TIME = "TIME";
    public static String DISTANCE = "DISTANCE";
    public static String LIQUID = "LIQUID";

//    public static HashMap<String, Integer> unitGroups;
//
//    static
//    {
//        unitGroups = new HashMap<String, Integer>();
//
//        unitGroups.put(WEIGHT, 0);
//        unitGroups.put(COUNTABLE, 1);
//        unitGroups.put(TIME, 2);
//        unitGroups.put(DISTANCE, 3);
//        unitGroups.put(LIQUID, 4);
//    }

    public UnitGroup()
    {
        entityName = "UnitGroup";
        units = new ArrayList<Unit>();
    }

    public UnitGroup(Long id, String name)
    {
        entityName = "UnitGroup";
        units = new ArrayList<Unit>();

        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 20)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Collection<Unit> getUnits()
    {
        return units;
    }

    public void setUnits(Collection<Unit> units)
    {
        this.units = units;
    }

    @Override
    @Transient
    public void clearIdFields()
    {
        super.clearIdFields();

        Unit unit = null;
        Iterator itr = units.iterator();

        while (itr.hasNext())
        {
            unit = (Unit)itr.next();
            unit.clearIdFields();
        }
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
