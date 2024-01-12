package com.example.online_shopping.user_types;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.user_accounts.User;
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
@Table(name = "userType")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "typeId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<User> users;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
