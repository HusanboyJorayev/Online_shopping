package com.example.online_shopping.cart;

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
public class CartService implements SimpleCrud<Integer, CartDto> {
    private final CartValidation cartValidation;
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public ResponseEntity<CartDto> create(CartDto dto) {
        List<ErrorDto> list = this.cartValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        Cart cart = this.cartMapper.toEntity(dto);
        cart.setCreatedAt(LocalDateTime.now());
        this.cartRepository.save(cart);
        return ResponseEntity.ok().body(this.cartMapper.toDto(cart));
    }

    @Override
    public ResponseEntity<CartDto> get(Integer id) {
        Optional<Cart> optional = this.cartRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var cart = optional.get();
        return ResponseEntity.ok().body(this.cartMapper.toDto(cart));
    }

    public ResponseEntity<CartDto> getWithOrder(Integer id) {
        Optional<Cart> optional = this.cartRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var cart = optional.get();
        return ResponseEntity.ok().body(this.cartMapper.toDtoWithOrder(cart));
    }

    @Override
    public ResponseEntity<CartDto> update(CartDto dto, Integer id) {
        List<ErrorDto> list = this.cartValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.cartRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var cart = optional.get();
        cart.setUpdatedAt(LocalDateTime.now());
        this.cartMapper.update(cart, dto);
        this.cartRepository.save(cart);
        return ResponseEntity.ok().body(this.cartMapper.toDto(cart));
    }

    @Override
    public ResponseEntity<CartDto> delete(Integer id) {
        var optional = this.cartRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var cart = optional.get();
        cart.setDeletedAt(LocalDateTime.now());
        this.cartRepository.delete(cart);
        return ResponseEntity.ok().body(this.cartMapper.toDto(cart));
    }
}
