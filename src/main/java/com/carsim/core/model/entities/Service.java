package com.carsim.core.model.entities;

import java.util.ArrayList;
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

import com.structure.BaseEntity;


@Entity
public class Service extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String description;
    private Company company;
    private UnitGroup unitGroup;
    private ServiceCategory category;

    private double vatRate;
    private double defaultPrice;
    private boolean isVatIncluded;
    private Currency currency;

    private Collection<ServiceContent> contents;
    private Collection<ServicePrice> prices;
    
    //0: Active, 1: SoldOut, 2: NotInStock
    private int sellingStatus;
    private boolean inUse;
    
    public final static byte SELLINGTATUS_ACTIVE=0;    
    public final static byte SELLINGSTATUS_SOLDOUT=1;
    public final static byte SELLINGSTATUS_NOTINSTOCK=2;

    public Service()
    {
        entityName = "Service";
        
        this.contents=new ArrayList<ServiceContent>();
    }

    public Service(Long id, String code, String name)
    {
        entityName = "Service";
        this.id = id;
        this.code = code;
        this.name = name;     
        
        this.contents=new ArrayList<ServiceContent>();
    }

    public Service(Long id, String code, String name, UnitGroup unitGroup)
    {
        entityName = "Service";
        this.id = id;
        this.code = code;
        this.name = name;
        this.unitGroup = unitGroup;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isVatIncluded() {
		return isVatIncluded;
	}

	public void setVatIncluded(boolean isVatIncluded) {
		this.isVatIncluded = isVatIncluded;
	}

	@Column(name = "CODE", unique = true, length = 7)
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Column(name = "NAME", length = 20)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 20)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

	@ManyToOne(targetEntity = Company.class, cascade = { })
    @JoinColumn(name = "COMPANYID")
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(targetEntity = UnitGroup.class, cascade = { })
    @JoinColumn(name = "UNITGROUPID")
    public UnitGroup getUnitGroup()
    {
        return unitGroup;
    }

    public void setUnitGroup(UnitGroup unitGroup)
    {
        this.unitGroup = unitGroup;
    }

    @ManyToOne(targetEntity = ServiceCategory.class, cascade = { })
    @JoinColumn(name = "CATEGORYID")
    public ServiceCategory getCategory()
    {
        return category;
    }

    public void setCategory(ServiceCategory category)
    {
        this.category = category;
    }

    @Column(name = "INUSE")
    public boolean isInUse()
    {
        return inUse;
    }

    public void setInUse(boolean inUse)
    {
        this.inUse = inUse;
    }

    public void setVatRate(double vatRate)
    {
        this.vatRate = vatRate;
    }

    @Column(name = "VATRATE")
    public double getVatRate()
    {
        return vatRate;
    }

    public void setDefaultPrice(double defaultPrice)
    {
        this.defaultPrice = defaultPrice;
    }

    public double getDefaultPrice()
    {
        return defaultPrice;
    }

    public void setIsVatIncluded(boolean isVatIncluded)
    {
        this.isVatIncluded = isVatIncluded;
    }

    @Column(name = "VATINCLUDED")
    public boolean isIsVatIncluded()
    {
        return isVatIncluded;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    @ManyToOne(targetEntity = Currency.class, cascade = { })
    @JoinColumn(name = "CURRENCYID")
    public Currency getCurrency()
    {
        return currency;
    }

    public void setSellingStatus(int sellingStatus)
    {
        this.sellingStatus = sellingStatus;
    }

    @Column(name = "SELLINGSTATUS")
    public int getSellingStatus()
    {
        return sellingStatus;
    }

    public void setContents(Collection<ServiceContent> contents)
    {
        this.contents = contents;
    }

    @OneToMany(targetEntity = ServiceContent.class, fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "SERVICEID")
    public Collection<ServiceContent> getContents()
    {
        return contents;
    }

    public Collection<ServicePrice> getPrices() {
		return prices;
	}


    @OneToMany(targetEntity = ServiceContent.class, fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "SERVICEID")
	public void setPrices(Collection<ServicePrice> prices) {
		this.prices = prices;
	}

	@Override
    public String toString()
    {
        return getCode() + "-" + getName();
    }
}
