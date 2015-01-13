package com.carsim.core.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class CompanyUser extends Account
{
	private Company company;
    private Date dateOfBirth;
    private int gender;

    public CompanyUser()
    {
        entityName = "CompanyUser";
        setPassive(true);
    }

    @OneToOne(targetEntity = Company.class, cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "COMPANYID")
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
