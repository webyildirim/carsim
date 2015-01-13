package com.carsim.core.model.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.structure.BaseEntity;


@Entity
public class Company extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String officialName;
    private String taxOffice;
    private String taxNo;
    private Address address;
    //private Collection<Branch> branches;
    private Currency currency;
    private String email;

    @OneToMany(targetEntity = Contact.class, mappedBy="company", fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    private Collection<Contact> contacts;
    public Company()
    {
        entityName = "Company";
        //this.branches = new ArrayList<Branch>();
    }

//    public void setBranches(Collection<Branch> branches)
//    {
//        this.branches = branches;
//    }
//
//    @OneToMany(targetEntity = Branch.class, fetch = (FetchType.LAZY), cascade = { CascadeType.ALL })
//    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
//    @JoinColumn(name = "COMPANYID")
//    public Collection<Branch> getBranches()
//    {
//        return branches;
//    }

    public void setContacts(Collection<Contact> contacts)
    {
        this.contacts = contacts;
    }
    
    public Collection<Contact> getContacts()
    {
        return contacts;
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

    @Column(name = "NAME", length = 50)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "OFFICIALNAME", length = 50)
    public String getOfficialName()
    {
        return officialName;
    }

    public void setOfficialName(String officialName)
    {
        this.officialName = officialName;
    }

    @Column(name = "TAXOFFICE", length = 50)
    public String getTaxOffice()
    {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice)
    {
        this.taxOffice = taxOffice;
    }

    @Column(name = "TAXNO", length = 15)
    public String getTaxNo()
    {
        return taxNo;
    }

    public void setTaxNo(String taxNo)
    {
        this.taxNo = taxNo;
    }

    @OneToOne(targetEntity = Address.class, cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "ADDRESSID")
    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    @ManyToOne(targetEntity = Address.class, cascade = { })
    @JoinColumn(name = "CURRENCYID")
    public Currency getCurrency()
    {
        return currency;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Column(name = "EMAIL")
    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString()
    {
        return getCode() + "-" + getName();
    }

}
