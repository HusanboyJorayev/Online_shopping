package com.example.online_shopping.transaction;

import com.example.online_shopping.products.ProductDto;
import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
public class transactionController implements SimpleCrud<Integer, TransactionDto> {
    private final TransactionService transactionService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto dto) {
        return transactionService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<TransactionDto> get(@RequestParam Integer id) {
        return transactionService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<TransactionDto> update(@RequestBody TransactionDto dto, @RequestParam Integer id) {
        return transactionService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<TransactionDto> delete(@RequestParam Integer id) {
        return transactionService.delete(id);
    }
}
