package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.ItemStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal itemPrice;
    private Long quantity;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus = ItemStatus.Created;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_ID")
    private ShoppingCart shoppingCart;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", itemStatus=" + itemStatus +
                '}';
    }
}
