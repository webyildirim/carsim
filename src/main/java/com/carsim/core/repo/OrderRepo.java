package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.Order;

/**
 * Created by webyildirim.
 */
public interface OrderRepo {

    public Order findOrder(Long id);

    public Order deleteOrder(Long id) throws Exception;

    public Order updateOrder(Long id, Order entity) throws Exception;
    
    public Order createDistrict(Order entity) throws Exception;
    
    public List<Order> findByCompany(Long companyId);

    public List<Order> findByCompanyAndStatus(Long companyId, byte orderStatus);

    public List<Order> findByCustomerUserAndCompany(Long customerUserId, Long companyId);

}
