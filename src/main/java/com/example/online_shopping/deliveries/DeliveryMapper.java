package com.example.online_shopping.deliveries;

import com.example.online_shopping.categories.Category;
import com.example.online_shopping.categories.CategoryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class DeliveryMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Delivery toEntity(DeliveryDto dto);

    public abstract DeliveryDto toDto(Delivery delivery);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Delivery delivery, DeliveryDto dto);
}
