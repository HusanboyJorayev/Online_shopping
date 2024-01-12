package com.example.online_shopping.transaction;

import com.example.online_shopping.simpleCrud.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionValidation {
    public List<ErrorDto> validate(TransactionDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getUserId() == null) {
            errors.add(new ErrorDto("userid cannot be null or empty", "userid"));
        }
        return errors;
    }
}
