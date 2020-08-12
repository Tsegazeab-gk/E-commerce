package com.super4tech.ecommerce.service;



import com.super4tech.ecommerce.domain.Notification;

import java.util.List;

public interface NotificationService {
    public Notification addNotification(Notification notification);

    public List<Notification> getAll();
    public List<Notification> getAllUnSeen();

    public Notification getNotification(Long id);

    public void deleteNotification(Long id);

    public Notification editNotification(Notification notification);
}
