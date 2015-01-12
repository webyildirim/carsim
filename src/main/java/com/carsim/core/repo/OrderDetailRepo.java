package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.OrderDetail;

/**
 * Created by webyildirim.
 */
public interface OrderDetailRepo {

    public OrderDetail findOrderDetail(Long id);
    
    public OrderDetail deleteOrderDetail(Long id) throws Exception;

    public OrderDetail updateOrderDetail(Long id, OrderDetail entity) throws Exception;
    
    public OrderDetail createOrderDetail(OrderDetail entity) throws Exception;

    public List<OrderDetail> findByOrder(Long orderId);

}
