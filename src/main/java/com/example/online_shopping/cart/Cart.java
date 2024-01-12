package com.example.online_shopping.cart;

import com.example.online_shopping.order.Order;
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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer userId;
    private Integer count;
    @OneToMany(mappedBy = "cartId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order>orders;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
