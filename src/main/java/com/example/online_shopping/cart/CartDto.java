package com.example.online_shopping.cart;

import com.example.online_shopping.order.Order;
import com.example.online_shopping.order.OrderDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {
    private Integer id;
    private Integer productId;
    @NotNull(message = "userId cannot be null")
    private Integer userId;
    private Integer count;

    private List<OrderDto> orders;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
