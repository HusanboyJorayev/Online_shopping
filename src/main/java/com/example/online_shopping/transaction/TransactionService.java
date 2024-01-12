package com.example.online_shopping.transaction;

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
public class TransactionService implements SimpleCrud<Integer, TransactionDto> {
    private final TransactionValidation transactionValidation;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public ResponseEntity<TransactionDto> create(TransactionDto dto) {
        List<ErrorDto> list = this.transactionValidation.validate(dto);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var transaction = this.transactionMapper.toEntity(dto);
        transaction.setCreatedAt(LocalDateTime.now());
        this.transactionRepository.save(transaction);
        return ResponseEntity.ok().body(this.transactionMapper.toDto(transaction));
    }

    @Override
    public ResponseEntity<TransactionDto> get(Integer id) {
        Optional<Transaction> optional = this.transactionRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }
        var transaction = optional.get();
        return ResponseEntity.ok().body(this.transactionMapper.toDto(transaction));
    }

    @Override
    public ResponseEntity<TransactionDto> update(TransactionDto dto, Integer id) {
        List<ErrorDto> list = this.transactionValidation.validate(dto);
        if (!list.isEmpty()) {
            return null;
        }
        var optional = this.transactionRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var transaction = optional.get();
        transaction.setUpdatedAt(LocalDateTime.now());
        this.transactionMapper.update(transaction, dto);
        this.transactionRepository.save(transaction);
        return ResponseEntity.ok().body(this.transactionMapper.toDto(transaction));
    }

    @Override
    public ResponseEntity<TransactionDto> delete(Integer id) {
        var optional = this.transactionRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return null;
        }
        var transaction = optional.get();
        transaction.setDeletedAt(LocalDateTime.now());
        this.transactionRepository.delete(transaction);
        return ResponseEntity.ok().body(this.transactionMapper.toDto(transaction));
    }
}
