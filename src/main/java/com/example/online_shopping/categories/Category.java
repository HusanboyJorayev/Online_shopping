package com.example.online_shopping.categories;

import com.example.online_shopping.payment.Payment;
import com.example.online_shopping.products.Product;
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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "categoryId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product> products;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
