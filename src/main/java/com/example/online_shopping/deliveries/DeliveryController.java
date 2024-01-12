package com.example.online_shopping.deliveries;


import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("delivery")
public class DeliveryController implements SimpleCrud<Integer, DeliveryDto> {
    private final DeliveryService deliveryService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<DeliveryDto> create(@RequestBody DeliveryDto dto) {
        return deliveryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<DeliveryDto> get(@RequestParam Integer id) {
        return deliveryService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<DeliveryDto> update(@RequestBody DeliveryDto dto, @RequestParam Integer id) {
        return deliveryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<DeliveryDto> delete(@RequestParam Integer id) {
        return deliveryService.delete(id);
    }
}
