package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.OrderDetail;

/**
 * Created by webyildirim.
 */
public class OrderDetailList {
    private List<OrderDetail> entities = new ArrayList<OrderDetail>();
    private Long orderId;

    public OrderDetailList(Long cityId, List<OrderDetail> entities) {
        this.orderId = cityId;
        this.entities = entities;
    }

    public List<OrderDetail> getEntities() {
        return entities;
    }

    public void setEntities(List<OrderDetail> entities) {
        this.entities = entities;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
