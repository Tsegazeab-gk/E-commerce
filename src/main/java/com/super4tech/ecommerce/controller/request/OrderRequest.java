package com.super4tech.ecommerce.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

//    @NotEmpty
//    @Valid
//    private List<ItemRequest> itemRequests;

//    @NotNull
//    private AddressRequest billingAddress;
//
//    @NotNull
//    private AddressRequest shippingAddress;

    private Long billingAddress;
    private Long shippingAddress;
    private Long paymentCard;

    private String receiver;

    private boolean applyCoupon;

    @Data
    public static class ItemRequest {

        @NotNull
        private Long productId;

        @NotNull
        @Positive
        private Integer quantity;
    }
}
