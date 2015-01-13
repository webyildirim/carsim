package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.structure.BaseEntity;

@Entity
public class District extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String name;
    private String internationalName;
    @ManyToOne
    private City city;

    public District()
    {
        entityName = "District";
    }

    public District(Long id, String name)
    {
        entityName = "District";
        
        this.id=id;
        this.name=name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "NAME")
    public String getName()
    {
        return name;
    }

    public void setInternationalName(String internationalName)
    {
        this.internationalName = internationalName;
    }

    @Column(name = "INTERNATIONALNAME", length = 40)
    public String getInternationalName()
    {
        return internationalName;
    }

    public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
    public String toString()
    {
        return getName();
    }
}
