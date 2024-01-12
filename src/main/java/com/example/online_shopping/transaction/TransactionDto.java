package com.example.online_shopping.transaction;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Integer id;
    @NotNull
    private Integer userId;
    private String tranceType;
    private String description;
    private String date;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
