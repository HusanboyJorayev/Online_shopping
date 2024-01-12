package com.example.online_shopping.user_accounts;

import com.example.online_shopping.cart.CartMapper;
import com.example.online_shopping.deliveries.DeliveryMapper;
import com.example.online_shopping.order.OrderMapper;
import com.example.online_shopping.payment.PaymentMapper;
import com.example.online_shopping.products.ProductMapper;
import com.example.online_shopping.transaction.TransactionMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class UserMapper {
    @Autowired
    protected OrderMapper orderMapper;
    @Autowired
    protected CartMapper cartMapper;
    @Autowired
    protected ProductMapper productMapper;
    @Autowired
    protected DeliveryMapper deliveryMapper;
    @Autowired
    protected TransactionMapper transactionMapper;
    @Autowired
    protected PaymentMapper paymentMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "orders")
    @Mapping(ignore = true, target = "carts")
    @Mapping(ignore = true, target = "products")
    @Mapping(ignore = true, target = "deliveries")
    @Mapping(ignore = true, target = "transactions")
    @Mapping(ignore = true, target = "payments")
    public abstract User toEntity(UserDto dto);


    @Mapping(ignore = true, target = "orders")
    @Mapping(ignore = true, target = "carts")
    @Mapping(ignore = true, target = "products")
    @Mapping(ignore = true, target = "deliveries")
    @Mapping(ignore = true, target = "transactions")
    @Mapping(ignore = true, target = "payments")
    public abstract UserDto toDto(User user);


    @Mapping(target = "orders", expression = "java(user.getOrders().stream().map(this.orderMapper::toDto).toList())")
    @Mapping(target = "carts", expression = "java(user.getCarts().stream().map(this.cartMapper::toDto).toList())")
    @Mapping(target = "products", expression = "java(user.getProducts().stream().map(this.productMapper::toDto).toList())")
    @Mapping(target = "deliveries", expression = "java(user.getDeliveries().stream().map(this.deliveryMapper::toDto).toList())")
    @Mapping(target = "transactions", expression = "java(user.getTransactions().stream().map(this.transactionMapper::toDto).toList())")
    @Mapping(target = "payments", expression = "java(user.getPayments().stream().map(this.paymentMapper::toDto).toList())")
    public abstract UserDto toDtoWithOthers(User user);


    @Mapping(ignore = true, target = "orders")
    @Mapping(ignore = true, target = "carts")
    @Mapping(ignore = true, target = "products")
    @Mapping(ignore = true, target = "deliveries")
    @Mapping(ignore = true, target = "transactions")
    @Mapping(ignore = true, target = "payments")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget User user, UserDto dto);


    public void view(User user, UserDto dto) {
        dto.setOrders(user.getOrders().stream().map(this.orderMapper::toDto).toList());
        dto.setCarts(user.getCarts().stream().map(this.cartMapper::toDto).toList());
        dto.setProducts(user.getProducts().stream().map(this.productMapper::toDto).toList());
        dto.setDeliveries(user.getDeliveries().stream().map(this.deliveryMapper::toDto).toList());
        dto.setTransactions(user.getTransactions().stream().map(this.transactionMapper::toDto).toList());
        dto.setPayments(user.getPayments().stream().map(this.paymentMapper::toDto).toList());
    }
}
