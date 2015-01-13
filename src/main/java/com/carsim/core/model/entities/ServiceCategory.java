package com.carsim.core.model.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.structure.BaseEntity;

@Entity
public class ServiceCategory extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(targetEntity=ServiceCategory.class, mappedBy = "dependentCategory", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Collection<ServiceCategory> subCategories;
    @ManyToOne
    private ServiceCategory dependentCategory;

    public ServiceCategory()
    {
        entityName = "ServiceCategory";
    }

    public ServiceCategory(Long id, String name)
    {
        entityName = "ServiceCategory";

        this.id = id;
        this.name = name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ServiceCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Collection<ServiceCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	public ServiceCategory getDependentCategory() {
		return dependentCategory;
	}

	public void setDependentCategory(ServiceCategory dependentCategory) {
		this.dependentCategory = dependentCategory;
	}

	@Column(name = "NAME", unique = true, length = 15)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 30)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return getName();
    }

}
