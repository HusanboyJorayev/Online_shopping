package com.example.online_shopping.user_accounts;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.deliveries.Delivery;
import com.example.online_shopping.order.Order;
import com.example.online_shopping.payment.Payment;
import com.example.online_shopping.products.Product;
import com.example.online_shopping.transaction.Transaction;
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
@Table(name = "userAccount")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer typeId;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String contactNumber;
    private String password;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order>orders;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cart>carts;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product>products;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Delivery>deliveries;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Transaction>transactions;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Payment>payments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
