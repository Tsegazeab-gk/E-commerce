package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Notification;
import com.super4tech.ecommerce.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notif")
public class NotificationController {
    private NotificationService notificationService;

    @Autowired
    public NotificationController(@Qualifier("NotificationService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String index(Model model) {
        List<Notification> notifications = notificationService.getAll();
        model.addAttribute("notifications", notifications);
        return "notification/index";
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable("id") Long id) {
        Notification notification = notificationService.getNotification(id);
        ModelAndView mv = new ModelAndView("notification/detail");
        mv.addObject("notification", notification);

        notification.setSeen(true);
        notificationService.editNotification(notification);
        return mv;
    }

    @ModelAttribute("unSeenNotifications")
    public List<Notification> unSeenNotification() {
        List<Notification> notifications = notificationService.getAllUnSeen();
        return notifications;
    }

}
