package com.carsim.core.model.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.structure.BaseEntity;


@Entity
public class City extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String name;
    private String internationalName;
    private Collection<District> districts;

    public City()
    {
        entityName = "City";
        this.districts = new ArrayList<District>();
    }
    
    public City(Long id, String name)
    {
        entityName = "City";
        this.districts = new ArrayList<District>();
        
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

    public void setDistricts(Collection<District> districts)
    {
        this.districts = districts;
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

    @OneToMany(targetEntity = District.class, cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "CITYID")
    public Collection<District> getDistricts()
    {
        return districts;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
