package com.example.online_shopping.user_accounts;

import com.example.online_shopping.simpleCrud.ErrorDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidation {

    public List<ErrorDto> validate(UserDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getTypeId() == null) {
            errors.add(new ErrorDto("typeId cannot be null", "typeId"));
        }
        if (StringUtils.isBlank(dto.getName())) {
            errors.add(new ErrorDto("name cannot be null or empty", "name"));
        }
        if (StringUtils.isBlank(dto.getPassword())) {
            errors.add(new ErrorDto("password cannot be null or empty", "password"));
        }
        return errors;
    }
}
