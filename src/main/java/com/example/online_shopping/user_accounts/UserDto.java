package com.example.online_shopping.user_accounts;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.cart.CartDto;
import com.example.online_shopping.deliveries.DeliveryDto;
import com.example.online_shopping.order.Order;
import com.example.online_shopping.order.OrderDto;
import com.example.online_shopping.payment.Payment;
import com.example.online_shopping.payment.PaymentDto;
import com.example.online_shopping.products.Product;
import com.example.online_shopping.products.ProductDto;
import com.example.online_shopping.transaction.Transaction;
import com.example.online_shopping.transaction.TransactionDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotNull
    private Integer typeId;
    @NotBlank
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String contactNumber;
    @NotBlank
    private String password;

    private List<OrderDto> orders;
    private List<CartDto> carts;
    private List<ProductDto> products;
    private List<DeliveryDto> deliveries;
    private List<TransactionDto> transactions;
    private List<PaymentDto>payments;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
