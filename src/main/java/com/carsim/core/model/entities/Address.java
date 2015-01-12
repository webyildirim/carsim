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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.structure.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ADDRESSTYPE", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Address")
public class Address extends BaseEntity
{   
	@Id @GeneratedValue
    private Long id;
    private String street; //sokak, cadde
    private String region; //mahalle, semt
    private District district; //ilce
    private City city; //þehir
    private Country country;
    private String zip; //posta kodu
    private String addressType;
    //google map integration
    private String latitude;
    private String longitude;

    public Address()
    {
        entityName = "Address";
        setAddressType(getEntityName());
    }
    
    public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "STREET", length = 200)
    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    @Column(name = "ZIP", length = 10)
    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Column(name = "REGION", length = 40)
    public String getRegion()
    {
        return region;
    }

    @ManyToOne(targetEntity = Country.class, cascade = { })
    @JoinColumn(name = "COUNTRYID")
    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public void setAddressType(String addressType)
    {
        this.addressType = addressType;
    }

    @Column(name = "DISTRICT", length = 30)
    public String getAddressType()
    {
        return addressType;
    }

    public void setDistrict(District district)
    {
        this.district = district;
    }

    @ManyToOne(targetEntity = District.class, cascade = { })
    @JoinColumn(name = "DISTRICTID")
    public District getDistrict()
    {
        return district;
    }

    public void setCity(City city)
    {
        this.city = city;
    }


    @ManyToOne(targetEntity = City.class, cascade = { })
    @JoinColumn(name = "CITYID")
    public City getCity()
    {
        return city;
    }

    @Override
    public String toString()
    {
        return getStreet() + " " + getRegion() + " " + getDistrict() + " " + getCity() + " " + getZip();
    }
}
