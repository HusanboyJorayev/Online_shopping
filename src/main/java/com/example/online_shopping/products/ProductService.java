package com.example.online_shopping.products;

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
public class ProductService implements SimpleCrud<Integer, ProductDto> {
    private final ProductValidation productValidation;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductDto> create(ProductDto dto) {
        List<ErrorDto> list = this.productValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var product = this.productMapper.toEntity(dto);
        product.setCreatedAt(LocalDateTime.now());
        this.productRepository.save(product);
        return ResponseEntity.ok().body(this.productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<ProductDto> get(Integer id) {
        Optional<Product> optional = this.productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var product = optional.get();
        return ResponseEntity.ok().body(this.productMapper.toDto(product));
    }

    public ResponseEntity<ProductDto> getWithCartAndPayment(Integer id) {
        Optional<Product> optional = this.productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var product = optional.get();
        return ResponseEntity.ok().body(this.productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<ProductDto> update(ProductDto dto, Integer id) {
        List<ErrorDto> list = this.productValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var product = optional.get();
        product.setUpdatedAt(LocalDateTime.now());
        this.productMapper.update(product, dto);
        this.productRepository.save(product);
        return ResponseEntity.ok().body(this.productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<ProductDto> delete(Integer id) {
        var optional = this.productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var product = optional.get();
        product.setDeletedAt(LocalDateTime.now());
        this.productRepository.delete(product);
        return ResponseEntity.ok().body(this.productMapper.toDto(product));
    }
}
