package com.carsim.core.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.structure.BaseEntity;

@Entity(name = "Unit")
public class Unit extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private boolean baseUnit;

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

	@Column(name = "CODE", length = 8)
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

    @Column(name = "ISBASEUNIT")
    public boolean isBaseUnit()
    {
        return baseUnit;
    }

    public void setBaseUnit(boolean baseUnit)
    {
        this.baseUnit = baseUnit;
    }

    @Override
    public String toString()
    {
        return getCode();
        // return getCode() + "(" + getName() + ")";
    }

}
