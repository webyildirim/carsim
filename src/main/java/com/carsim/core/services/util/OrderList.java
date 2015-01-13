package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.Order;

/**
 * Created by webyildirim.
 */
public class OrderList {
	private List<Order> entities = new ArrayList<Order>();
	private Long companyId;
	private Long customerId;

	public OrderList(Long cityId, List<Order> entities) {
		this.companyId = cityId;
		this.entities = entities;
	}

	public List<Order> getEntities() {
		return entities;
	}

	public void setEntities(List<Order> entities) {
		this.entities = entities;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
