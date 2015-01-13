package com.carsim.core.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.structure.BaseEntity;

@Entity(name = "Unit")
public class Unit extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String code;
    private String name;
    
    @ManyToOne
    private UnitGroup unitGroup;

    public Unit()
    {
        entityName = "Unit";
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

	@Column(name = "CODE", unique=true, length = 8)
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
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

    @Override
    public String toString()
    {
        return getCode() + "(" + getName() + ")";
    }

}
