package com.carsim.core.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.structure.BaseEntity;


@Entity
public class OrderDetail extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private Service service;
    private Unit unit;
    private double quantity;
    private double calculatedPrice;
    private Currency currency;
    private Comment comment;

    public OrderDetail()
    {
        this.entityName = "OrderDetail";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setService(Service service)
    {
        this.service = service;
    }

    @ManyToOne(targetEntity = Service.class, cascade = { })
    @JoinColumn(name = "SERVICEID")
    public Service getService()
    {
        return service;
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }

    @ManyToOne(targetEntity = Unit.class, cascade = { })
    @JoinColumn(name = "UNITID")
    public Unit getUnit()
    {
        return unit;
    }

    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    @Column(name = "QUANTITY")
    public double getQuantity()
    {
        return quantity;
    }

    public void setCalculatedPrice(double calculatedPrice)
    {
        this.calculatedPrice = calculatedPrice;
    }

    @Column(name = "CALCULATEDPRICE")
    public double getCalculatedPrice()
    {
        return calculatedPrice;
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

    public void setComment(Comment comment)
    {
        this.comment = comment;
    }

    @OneToOne(targetEntity = Comment.class, cascade = { CascadeType.ALL })
    @org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JoinColumn(name = "ORDERDETCOMMENTID")
    public Comment getOrderDetailComment()
    {
        return comment;
    }

    @Override
    public String toString()
    {
        return "" + getId();
    }
}
