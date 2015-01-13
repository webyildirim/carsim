package com.carsim.core.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class CustomerUser extends Account
{
    @OneToMany(targetEntity = DeliveryAddress.class,mappedBy="customerUser", fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    private Collection<DeliveryAddress> deliveryAddresses;
    private Date dateOfBirth;
    private int maritalStatus;
    private int gender;
    private String phone;

    public CustomerUser()
    {
        entityName = "CustomerUser";
        setPassive(true);
        deliveryAddresses = new ArrayList<DeliveryAddress>();
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setDeliveryAddresses(Collection<DeliveryAddress> deliveryAddresses)
    {
        this.deliveryAddresses = deliveryAddresses;
    }

    public Collection<DeliveryAddress> getDeliveryAddresses()
    {
        return deliveryAddresses;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setMaritalStatus(int maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "MARITALSTATUS")
    public int getMaritalStatus()
    {
        return maritalStatus;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    @Column(name = "GENDER")
    public int getGender()
    {
        return gender;
    }
}
