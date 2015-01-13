package com.carsim.core.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.structure.BaseEntity;


@Entity
public class ServicePrice extends BaseEntity{

	@Id @GeneratedValue
    private Long id;
	private String code;
	private String feature;
	private double price;
	@ManyToOne
	private Service service;

    public ServicePrice()
    {
        entityName = "ServicePrice";
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getFeature()+" - "+getPrice();
	}

}
