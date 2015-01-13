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
public class Order extends BaseEntity
{
	@Id @GeneratedValue
    private Long id;
    private String orderType;
    private String customerNote;
    
    private double totalPrice;
    private Currency currency;
    
    //0:not set, 1:cash, 2:credit card, 3:multinet, 4:sodexho, 5:ticket
    private int paymentType;
    
    private CustomerUser customer;
    private Company company;


    @OneToMany(targetEntity = OrderDetail.class, mappedBy="order", fetch = (FetchType.EAGER), cascade = { CascadeType.ALL })
    private Collection<OrderDetail> details;

    //0: creating, 1:standing, 2: completed, 3:cancelled
    private byte orderStatus;

    public final static byte ORDERSTATUS_CREATING = 0;
    public final static byte ORDERSTATUS_STANDNG = 1;
    public final static byte ORDERSTATUS_COMPLETED = 2;
    public final static byte ORDERSTATUS_CANCELLED = 3;

    public final static int PAYMENTTYPE_NOTSET = 0;
    public final static int PAYMENTTYPE_CASH = 1;
    public final static int PAYMENTTYPE_CREDITCARD = 2;
    public final static int PAYMENTTYPE_MULTINET = 3;
    public final static int PAYMENTTYPE_SODEXHO = 4;
    public final static int PAYMENTTYPE_TICKET = 5;


    public Order()
    {
        this.entityName = "Order";
        setOrderType(this.getEntityName());
        setPaymentType(PAYMENTTYPE_NOTSET);
        setOrderStatus(ORDERSTATUS_CREATING);
        
        details = new ArrayList<OrderDetail>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDetails(Collection<OrderDetail> details)
    {
        this.details = details;
    }
    
    public Collection<OrderDetail> getDetails()
    {
        return details;
    }

    public void setCustomerNote(String customerNote)
    {
        this.customerNote = customerNote;
    }

    @Column(name = "CUSTOMERNOTE")
    public String getCustomerNote()
    {
        return customerNote;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    @Column(name = "TOTALPRICE")
    public double getTotalPrice()
    {
        return totalPrice;
    }

    public Company getCompany() {
		return company;
	}

    @ManyToOne(targetEntity = Company.class, cascade = { })
    @JoinColumn(name = "COMPANYID")
	public void setCompany(Company company) {
		this.company = company;
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

    public void setOrderStatus(byte orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    @Column(name = "ORDERSTATUS")
    public byte getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    @Column(name = "ORDERTYPE")
    public String getOrderType()
    {
        return orderType;
    }

    public void setPaymentType(int paymentType)
    {
        this.paymentType = paymentType;
    }

    @Column(name = "PAYMENTTYPE")
    public int getPaymentType()
    {
        return paymentType;
    }

    public void setCustomerUser(CustomerUser customer)
    {
        this.customer = customer;
    }

    @ManyToOne(targetEntity = CustomerUser.class, cascade = { })
    @JoinColumn(name = "CUSTOMERID")
    public CustomerUser getCustomer()
    {
        return customer;
    }

    @Override
    public String toString()
    {
        return "" + getId();
    }
}
