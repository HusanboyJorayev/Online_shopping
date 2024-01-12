package com.example.online_shopping.user_types;

import com.example.online_shopping.simpleCrud.ErrorDto;
import com.example.online_shopping.simpleCrud.SimpleCrud;
import com.example.online_shopping.user_accounts.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeService implements SimpleCrud<Integer, TypeDto> {
    private final TypeValidation typeValidation;
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Override
    public ResponseEntity<TypeDto> create(TypeDto dto) {
        List<ErrorDto> list = this.typeValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var type = this.typeMapper.toEntity(dto);
        type.setCreatedAt(LocalDateTime.now());
        this.typeRepository.save(type);
        return ResponseEntity.ok().body(this.typeMapper.toDto(type));
    }

    @Override
    public ResponseEntity<TypeDto> get(Integer id) {
        Optional<Type> optional = this.typeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var type = optional.get();
        return ResponseEntity.ok().body(this.typeMapper.toDto(type));
    }

    public ResponseEntity<TypeDto> getWithUser(Integer id) {
        Optional<Type> optional = this.typeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var type = optional.get();
        return ResponseEntity.ok().body(this.typeMapper.toDtoWithUser(type));
    }

    @Override
    public ResponseEntity<TypeDto> update(TypeDto dto, Integer id) {
        List<ErrorDto> list = this.typeValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.typeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var type = optional.get();
        type.setUpdatedAt(LocalDateTime.now());
        this.typeMapper.update(type, dto);
        this.typeRepository.save(type);
        return ResponseEntity.ok().body(this.typeMapper.toDto(type));
    }

    @Override
    public ResponseEntity<TypeDto> delete(Integer id) {
        var optional = this.typeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var type = optional.get();
        type.setDeletedAt(LocalDateTime.now());
        this.typeRepository.delete(type);
        return ResponseEntity.ok().body(this.typeMapper.toDto(type));
    }
}

