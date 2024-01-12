package com.example.online_shopping.user_types;

import com.example.online_shopping.simpleCrud.ErrorDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeValidation {

    public List<ErrorDto> validate(TypeDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (StringUtils.isBlank(dto.getName())) {
            errors.add(new ErrorDto("name cannot be null or mepty", "name"));
        }
        return errors;
    }
}
