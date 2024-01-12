package com.example.online_shopping.cart;

import com.example.online_shopping.simpleCrud.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartValidation {

    public List<ErrorDto> validate(CartDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getUserId() == null) {
            errors.add(new ErrorDto("userId cannot be null", "userId"));
        }
        return errors;
    }
}
