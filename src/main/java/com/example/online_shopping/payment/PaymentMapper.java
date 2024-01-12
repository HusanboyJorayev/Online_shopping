package com.example.online_shopping.payment;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Payment toEntity(PaymentDto dto);

    public abstract PaymentDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Payment payment, PaymentDto dto);
}
