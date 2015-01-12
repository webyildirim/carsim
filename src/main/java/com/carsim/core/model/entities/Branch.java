package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.structure.BaseEntity;


@Entity
public class Branch extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String code;
    private String name;

    public Branch()
    {
        entityName = "Branch";
    }

    public Branch(Long id, String name)
    {
        entityName = "Branch";

        this.id = id;
        this.name = name;
    }
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", length = 10)
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Column(name = "NAME", length = 60)
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
        return getCode() + "-" + getName();
    }

}
