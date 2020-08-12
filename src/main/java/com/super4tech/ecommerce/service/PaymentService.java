package com.super4tech.ecommerce.service;


import com.super4tech.ecommerce.domain.Payment;

import java.util.List;

public interface PaymentService {

    Payment save(Payment payment);

    List<Payment> findAll();

    List<Payment> getAllByUserName(String username);

    Payment findById(Long id);

    Payment updatePayment(Payment payment);
}
