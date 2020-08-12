package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Payment;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.repository.PaymentRepository;
import com.super4tech.ecommerce.repository.ProductRepository;
import com.super4tech.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class PaymentRepositoryImpl extends GenericDaoImpl<Payment> implements PaymentRepository {

    public PaymentRepositoryImpl() {
        super.setDaoType(Payment.class );
    }


}
