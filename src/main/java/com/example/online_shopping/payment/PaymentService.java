package com.example.online_shopping.payment;

import com.example.online_shopping.order.Order;
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
public class PaymentService implements SimpleCrud<Integer, PaymentDto> {
    private final PaymentValidation paymentValidation;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public ResponseEntity<PaymentDto> create(PaymentDto dto) {
        List<ErrorDto> list = this.paymentValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var payment = this.paymentMapper.toEntity(dto);
        payment.setCreatedAt(LocalDateTime.now());
        this.paymentRepository.save(payment);
        return ResponseEntity.ok().body(this.paymentMapper.toDto(payment));
    }

    @Override
    public ResponseEntity<PaymentDto> get(Integer id) {
        Optional<Payment> optional = this.paymentRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var payment = optional.get();
        return ResponseEntity.ok().body(this.paymentMapper.toDto(payment));
    }

    @Override
    public ResponseEntity<PaymentDto> update(PaymentDto dto, Integer id) {
        List<ErrorDto> list = this.paymentValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.paymentRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var payment = optional.get();
        payment.setUpdatedAt(LocalDateTime.now());
        this.paymentMapper.update(payment, dto);
        this.paymentRepository.save(payment);
        return ResponseEntity.ok().body(this.paymentMapper.toDto(payment));
    }

    @Override
    public ResponseEntity<PaymentDto> delete(Integer id) {
        var optional = this.paymentRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var payment = optional.get();
        payment.setDeletedAt(LocalDateTime.now());
        this.paymentRepository.delete(payment);
        return ResponseEntity.ok().body(this.paymentMapper.toDto(payment));
    }
}
