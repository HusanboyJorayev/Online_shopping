package com.example.online_shopping.user_types;

import com.example.online_shopping.user_accounts.UserMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class TypeMapper {

    @Autowired
    protected UserMapper userMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "users")
    public abstract Type toEntity(TypeDto dto);

    @Mapping(ignore = true, target = "users")
    public abstract TypeDto toDto(Type type);

    @Mapping(target = "users", expression = "java(type.getUsers().stream().map(this.userMapper::toDto).toList())")
    public abstract TypeDto toDtoWithUser(Type type);


    @Mapping(ignore = true, target = "users")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Type type, TypeDto dto);

    public void view(Type type, TypeDto dto) {
        dto.setUsers(type.getUsers().stream().map(this.userMapper::toDto).toList());
    }
}
