package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Notification;
import com.super4tech.ecommerce.repository.NotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl extends  GenericDaoImpl<Notification> implements NotificationRepository {


    public NotificationRepositoryImpl() {
        super.setDaoType(Notification.class );
    }


}
