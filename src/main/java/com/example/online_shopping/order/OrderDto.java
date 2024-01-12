package com.example.online_shopping.order;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer cartId;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
