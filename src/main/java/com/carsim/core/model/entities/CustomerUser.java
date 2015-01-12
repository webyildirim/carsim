package com.carsim.core.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@DiscriminatorValue("CustomerUser")
@PrimaryKeyJoinColumn(name = "USERID", referencedColumnName = "ID")
public class CustomerUser extends Account
{
    private Collection<DeliveryAddress> deliveryAddresses;
    private Collection<Contact> contacts;
    private Date dateOfBirth;
    private int maritalStatus;
    private int gender;

    public CustomerUser()
    {
        entityName = "CustomerUser";
        setUserType(this.getEntityName());
        setPassive(true);
        deliveryAddresses = new ArrayList<DeliveryAddress>();
    }

    public void setDeliveryAddresses(Collection<DeliveryAddress> deliveryAddresses)
    {
        this.deliveryAddresses = deliveryAddresses;
    }

    @OneToMany(targetEntity = DeliveryAddress.class, fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "CUSTOMERUSERID")
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

    public void setContacts(Collection<Contact> contacts)
    {
        this.contacts = contacts;
    }
    
    @OneToMany(targetEntity = Contact.class, fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "CUSTOMERUSERID")
    public Collection<Contact> getContacts()
    {
        return contacts;
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
