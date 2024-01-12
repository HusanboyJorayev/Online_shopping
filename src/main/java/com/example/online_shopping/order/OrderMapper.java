package com.example.online_shopping.order;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Order toEntity(OrderDto dto);

    public abstract OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Order order, OrderDto dto);
}
