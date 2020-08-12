package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Payment;
import com.super4tech.ecommerce.repository.PaymentRepository;
import com.super4tech.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Payment> findAll() {
        Iterable<Payment> paymentIterable = paymentRepository.findAll();
        List<Payment> payments = new ArrayList<>();
        paymentIterable.forEach(payments::add);
        return payments;
    }

    @Override
    public List<Payment> getAllByUserName(String username) {
        Iterable<Payment> paymentIterable = paymentRepository.findAll();

        List<Payment> payments = new ArrayList<>();
        paymentIterable.forEach(payments::add);

        return payments.stream()
                //.filter(payment -> payment.getCartItem().getBuyer().getEmail() == username)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment findById(Long id) {
        Optional<Payment> payment = Optional.ofNullable(paymentRepository.findById(id));
        if (!payment.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Payment not found");
            //throw new Exception("Payment not found");
        }
        return payment.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment updatePayment(Payment payment) {
        Payment updatedPayment = paymentRepository.save(payment);
        return updatedPayment;
    }
}
