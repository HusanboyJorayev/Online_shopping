package com.example.online_shopping.deliveries;

import com.example.online_shopping.simpleCrud.ErrorDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryValidation {
    public List<ErrorDto> validate(DeliveryDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getUserId() == null) {
            errors.add(new ErrorDto("userId cannot be null", "userId"));
        }
        if (StringUtils.isBlank(dto.getDate())) {
            errors.add(new ErrorDto("date cannot be null or empty", "date"));
        }
        return errors;
    }
}
