package com.example.online_shopping.products;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.cart.CartDto;
import com.example.online_shopping.payment.Payment;
import com.example.online_shopping.payment.PaymentDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer categoryId;
    private String name;
    @NotNull
    private Double price;
    private Integer count;
    private String description;

    private List<PaymentDto> payments;
    private List<CartDto>carts;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
