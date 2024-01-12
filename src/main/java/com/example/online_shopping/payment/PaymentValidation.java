package com.example.online_shopping.payment;

import com.example.online_shopping.simpleCrud.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentValidation {

    public List<ErrorDto> validate(PaymentDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getProductId() == null) {
            errors.add(new ErrorDto("productId cannot be null", "productId"));
        }
        if (dto.getUserId() == null) {
            errors.add(new ErrorDto("userId cannot be null", "userId"));
        }
        return errors;
    }
}
