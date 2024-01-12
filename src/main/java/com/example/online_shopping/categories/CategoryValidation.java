package com.example.online_shopping.categories;

import com.example.online_shopping.simpleCrud.ErrorDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidation {

    public List<ErrorDto> validate(CategoryDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (StringUtils.isBlank(dto.getCategoryName())) {
            errors.add(new ErrorDto("categoryName cannot be null or empty", "categoryName"));
        }
        return errors;
    }
}
