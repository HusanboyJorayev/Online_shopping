package com.example.online_shopping.order;

import com.example.online_shopping.simpleCrud.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderValidation {

    public List<ErrorDto>validate(OrderDto dto){
        List<ErrorDto>errors=new ArrayList<>();
        if (dto.getUserId()==null){
            errors.add(new ErrorDto("userId cannot be null ","usreId"));
        }
        if (dto.getCartId()==null){
            errors.add(new ErrorDto("cartId cannot be null ","cartId"));
        }
        return errors;
    }
}
