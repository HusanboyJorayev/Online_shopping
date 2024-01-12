package com.example.online_shopping.deliveries;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private Integer id;
    @NotNull
    private Integer userId;
    @NotBlank
    private String date;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
