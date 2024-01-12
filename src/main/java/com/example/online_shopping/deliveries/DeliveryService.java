package com.example.online_shopping.deliveries;

import com.example.online_shopping.categories.Category;
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
public class DeliveryService implements SimpleCrud<Integer, DeliveryDto> {
    private final DeliveryValidation deliveryValidation;
    private final DeliveryMapper deliveryMapper;
    private final DeliveryRepository deliveryRepository;

    @Override
    public ResponseEntity<DeliveryDto> create(DeliveryDto dto) {
        List<ErrorDto> list = this.deliveryValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        Delivery delivery = this.deliveryMapper.toEntity(dto);
        delivery.setCreatedAt(LocalDateTime.now());
        this.deliveryRepository.save(delivery);
        return ResponseEntity.ok().body(this.deliveryMapper.toDto(delivery));
    }

    @Override
    public ResponseEntity<DeliveryDto> get(Integer id) {
        Optional<Delivery> optional = this.deliveryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var delivery = optional.get();
        return ResponseEntity.ok().body(this.deliveryMapper.toDto(delivery));
    }

    @Override
    public ResponseEntity<DeliveryDto> update(DeliveryDto dto, Integer id) {
        List<ErrorDto> list = this.deliveryValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.deliveryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var delivery = optional.get();
        delivery.setUpdatedAt(LocalDateTime.now());
        this.deliveryMapper.update(delivery, dto);
        this.deliveryRepository.save(delivery);
        return ResponseEntity.ok().body(this.deliveryMapper.toDto(delivery));
    }

    @Override
    public ResponseEntity<DeliveryDto> delete(Integer id) {
        var optional = this.deliveryRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var delivery = optional.get();
        delivery.setDeletedAt(LocalDateTime.now());
        this.deliveryRepository.delete(delivery);
        return ResponseEntity.ok().body(this.deliveryMapper.toDto(delivery));
    }
}
