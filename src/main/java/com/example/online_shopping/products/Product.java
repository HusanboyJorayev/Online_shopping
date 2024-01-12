package com.example.online_shopping.products;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.payment.Payment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private String name;
    private Double price;
    private Integer count;
    private String description;

    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Payment>payments;

    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cart>carts;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
