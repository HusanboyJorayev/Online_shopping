package com.example.online_shopping.order;

import com.example.online_shopping.simpleCrud.ErrorDto;
import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements SimpleCrud<Integer, OrderDto> {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderValidation orderValidation;

    @Override
    public ResponseEntity<OrderDto> create(OrderDto dto) {
        List<ErrorDto> list = this.orderValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        Order order = this.orderMapper.toEntity(dto);
        order.setCreatedAt(LocalDateTime.now());
        this.orderRepository.save(order);
        return ResponseEntity.ok().body(this.orderMapper.toDto(order));
    }

    @Override
    public ResponseEntity<OrderDto> get(Integer id) {
        Optional<Order> optional = this.orderRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var order = optional.get();
        return ResponseEntity.ok().body(this.orderMapper.toDto(order));
    }

    @Override
    public ResponseEntity<OrderDto> update(OrderDto dto, Integer id) {
        List<ErrorDto> list = this.orderValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.orderRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var order = optional.get();
        order.setUpdatedAt(LocalDateTime.now());
        this.orderMapper.update(order, dto);
        this.orderRepository.save(order);
        return ResponseEntity.ok().body(this.orderMapper.toDto(order));
    }

    @Override
    public ResponseEntity<OrderDto> delete(Integer id) {
        var optional = this.orderRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var order = optional.get();
        order.setDeletedAt(LocalDateTime.now());
        this.orderRepository.delete(order);
        return ResponseEntity.ok().body(this.orderMapper.toDto(order));
    }
}
