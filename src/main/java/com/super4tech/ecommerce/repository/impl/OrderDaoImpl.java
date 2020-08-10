package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.ZOrder;
import com.super4tech.ecommerce.repository.OrderDao;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDaoImpl extends GenericDaoImpl<ZOrder> implements OrderDao {

    public OrderDaoImpl() {
        super.setDaoType(ZOrder.class );
    }



}
