package com.example.online_shopping.payment;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Integer id;
    @NotNull
    private Integer productId;
    private Integer amount;
    private Integer quantity;
    @NotNull
    private Integer userId;
    private String date;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
