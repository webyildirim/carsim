package com.carsim.core.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("DeliveryAddress")
@PrimaryKeyJoinColumn(name = "ADDRESSID", referencedColumnName = "ID")
public class DeliveryAddress extends Address
{
    private String direction;
    private boolean defaultAddress;
    
    public DeliveryAddress()
    {
        entityName = "DeliveryAddress";
        setAddressType(this.getEntityName());
    }

    public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getDirection()
    {
        return direction;
    }
}
