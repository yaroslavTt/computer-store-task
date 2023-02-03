package com.example.app.model.orders;

import com.example.app.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice(){
        double sum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct op : orderProducts){
            sum += op.getTotalPrice();
        }
        return sum;
    }
    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }
}
