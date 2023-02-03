package com.example.app.model.orders;

import com.example.app.model.computers.Computer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct(Order order, Computer computer, Integer quantity){
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(computer);
        this.quantity = quantity;
    }

    @Transient
    public Computer getProduct(){
        return this.pk.getProduct();
    }

    @Transient
   public Double getTotalPrice(){
        return getProduct().getPrice() * getQuantity();
    }
}
