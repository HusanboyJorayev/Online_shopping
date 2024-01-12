package com.example.online_shopping.payment;

import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController implements SimpleCrud<Integer, PaymentDto> {
    private final PaymentService paymentService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto dto) {
        return paymentService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<PaymentDto> get(@RequestParam Integer id) {
        return paymentService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<PaymentDto> update(@RequestBody PaymentDto dto, @RequestParam Integer id) {
        return paymentService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<PaymentDto> delete(@RequestParam Integer id) {
        return paymentService.delete(id);
    }

}
