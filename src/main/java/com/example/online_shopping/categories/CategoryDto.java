package com.example.online_shopping.categories;

import com.example.online_shopping.products.Product;
import com.example.online_shopping.products.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer id;
    @NotBlank(message = "categoryName cannot be null or empty")
    private String categoryName;
    private String description;

    private List<ProductDto> products;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
