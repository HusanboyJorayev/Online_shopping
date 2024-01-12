package com.example.online_shopping.products;

import com.example.online_shopping.simpleCrud.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidation {

    public List<ErrorDto> validate(ProductDto dto) {
        List<ErrorDto> errors=new ArrayList<>();
        if (dto.getCategoryId() == null) {
            errors.add(new ErrorDto("categoryId cannot be null", "categoryId"));
        }
        if (dto.getUserId() == null) {
            errors.add(new ErrorDto("userId cannot be null", "userId"));
        }
        if (dto.getPrice() == null) {
            errors.add(new ErrorDto("price cannot be null", "price"));
        }
        return errors;
    }
}
