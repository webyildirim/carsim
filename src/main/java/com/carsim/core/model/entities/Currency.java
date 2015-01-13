package com.carsim.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.structure.BaseEntity;
import com.structure.ListValue;

@Entity(name = "Currency")
public class Currency extends BaseEntity implements ListValue
{
	@Id @GeneratedValue
    private Long id;
    private String name;
    private Integer orderNo;
    private boolean defaultValue;

    public Currency()
    {
        entityName = "Currency";
    }

    public Currency(Long id, String name)
    {
        entityName = "Currency";

        this.id = id;
        this.name = name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDefaultValue(boolean defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public boolean isDefaultValue()
    {
        return defaultValue;
    }

    @Column(name = "NAME", length = 10)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    @Column(name = "ORDERNO")
    public Integer getOrderNo()
    {
        return orderNo;
    }

    @Override
    public String toString()
    {
        return getName();
    }

    @Override
    @Transient
    public int compareTo(Object object)
    {
        if (!(object instanceof BaseEntity))
            throw new ClassCastException();

        Currency baseEntity = (Currency)object;
        Integer levelB = baseEntity.getOrderNo();
        Integer levelA = getOrderNo();
        try
        {
            if (isDefaultValue())
                levelA *= -1;
            else if (baseEntity.isDefaultValue())
                levelB *= -1;
            if (levelA == null && levelB == null)
                return getName().compareTo(baseEntity.getName());
            else if (levelB == null)
                return 0;
            else
                return levelA.compareTo(levelB);
        }
        catch (NullPointerException exc)
        {
            if (isDefaultValue())
                return ("-1"+getName()).compareTo(baseEntity.getName());
            else if (baseEntity.isDefaultValue())
                return getName().compareTo("-1"+baseEntity.getName());
            else
                return getName().compareTo(baseEntity.getName());
        }
    }
}
