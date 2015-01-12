package com.carsim.core.model.entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.structure.BaseEntity;

@Entity
public class Contact extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    // 1:telephone, 2:email 3:fax 4:web
    private int type;
    private String value;

    public static final int TYPE_TELEPHONE = 0;
    public static final int TYPE_EMAIL = 1;
    public static final int TYPE_FAX = 2;
    public static final int TYPE_WEB = 3;

    public Contact()
    {
        entityName = "Contact";
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TYPE")
    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    @Column(name = "VALUE", length = 50)
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return getValue();
    }
}
