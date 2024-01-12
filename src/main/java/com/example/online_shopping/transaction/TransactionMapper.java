package com.example.online_shopping.transaction;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Transaction toEntity(TransactionDto dto);

    public abstract TransactionDto toDto(Transaction transaction);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Transaction transaction, TransactionDto dto);
}
