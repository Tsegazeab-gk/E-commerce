package com.super4tech.ecommerce.validation;


import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private BuyerService buyerService;

    @Autowired
    public EmailValidator(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    public EmailValidator() {
    }

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return validateEmail(email);
    }

    public boolean validateEmail(String email) {
        Buyer buyer = null;

        try {
            buyer = buyerService.findByEmail(email);
        } catch (Exception e) {

        }
        return buyer == null ? true : false;
    }
}
