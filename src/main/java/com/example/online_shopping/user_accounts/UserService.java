package com.example.online_shopping.user_accounts;

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
public class UserService implements SimpleCrud<Integer, UserDto> {
    private final UserValidation userValidation;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<UserDto> create(UserDto dto) {
        List<ErrorDto> list = this.userValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var user = this.userMapper.toEntity(dto);
        user.setCreatedAt(LocalDateTime.now());
        this.userRepository.save(user);
        return ResponseEntity.ok().body(this.userMapper.toDto(user));
    }

    @Override
    public ResponseEntity<UserDto> get(Integer id) {
        Optional<User> optional = this.userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var user = optional.get();
        return ResponseEntity.ok().body(this.userMapper.toDto(user));
    }

    public ResponseEntity<UserDto> getWithOthers(Integer id) {
        Optional<User> optional = this.userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var user = optional.get();
        return ResponseEntity.ok().body(this.userMapper.toDtoWithOthers(user));
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto, Integer id) {
        List<ErrorDto> list = this.userValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var user = optional.get();
        user.setUpdatedAt(LocalDateTime.now());
        this.userMapper.update(user, dto);
        this.userRepository.save(user);
        return ResponseEntity.ok().body(this.userMapper.toDto(user));
    }

    @Override
    public ResponseEntity<UserDto> delete(Integer id) {
        var optional = this.userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var user = optional.get();
        user.setDeletedAt(LocalDateTime.now());
        this.userRepository.delete(user);
        return ResponseEntity.ok().body(this.userMapper.toDto(user));
    }
}
