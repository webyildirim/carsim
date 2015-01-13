package com.carsim.core.model.entities;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.structure.BaseEntity;


@Entity
public class Country extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String internationalName;
    @OneToMany(targetEntity = City.class, mappedBy = "country", fetch = FetchType.EAGER)
    private Collection<City> cities;

    public Country()
    {
        entityName = "Country";
        this.cities = new ArrayList<City>();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", length = 5)
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Column(name = "NAME", length = 40)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public void setCities(Collection<City> cities)
    {
        this.cities = cities;
    }

    public Collection<City> getCities()
    {
        return cities;
    }

    @Override
    public String toString()
    {
        return getName() + " (" + getCode() + ")";
    }
}
