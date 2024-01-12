package com.example.online_shopping.categories;

import com.example.online_shopping.cart.Cart;
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
public class CategoryService implements SimpleCrud<Integer, CategoryDto> {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryValidation categoryValidation;

    @Override
    public ResponseEntity<CategoryDto> create(CategoryDto dto) {
        List<ErrorDto> list = this.categoryValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        Category category = this.categoryMapper.toEntity(dto);
        category.setCreatedAt(LocalDateTime.now());
        this.categoryRepository.save(category);
        return ResponseEntity.ok().body(this.categoryMapper.toDto(category));
    }

    @Override
    public ResponseEntity<CategoryDto> get(Integer id) {
        Optional<Category> optional = this.categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var category = optional.get();
        return ResponseEntity.ok().body(this.categoryMapper.toDto(category));
    }

    public ResponseEntity<CategoryDto> getWithProduct(Integer id) {
        Optional<Category> optional = this.categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var category = optional.get();
        return ResponseEntity.ok().body(this.categoryMapper.toDtoWithProduct(category));
    }

    @Override
    public ResponseEntity<CategoryDto> update(CategoryDto dto, Integer id) {
        List<ErrorDto> list = this.categoryValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var category = optional.get();
        category.setUpdatedAt(LocalDateTime.now());
        this.categoryMapper.update(category, dto);
        this.categoryRepository.save(category);
        return ResponseEntity.ok().body(this.categoryMapper.toDto(category));
    }

    @Override
    public ResponseEntity<CategoryDto> delete(Integer id) {
        var optional = this.categoryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var category = optional.get();
        category.setDeletedAt(LocalDateTime.now());
        this.categoryRepository.delete(category);
        return ResponseEntity.ok().body(this.categoryMapper.toDto(category));
    }
}
