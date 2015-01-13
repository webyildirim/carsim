package com.carsim.core.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryAddress extends Address
{
    private String direction;
    private boolean defaultAddress;
    
    @ManyToOne
    private CustomerUser customerUser;
    
    public DeliveryAddress()
    {
        entityName = "DeliveryAddress";
    }

    public CustomerUser getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
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
