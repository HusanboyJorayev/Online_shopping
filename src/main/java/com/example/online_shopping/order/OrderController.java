package com.example.online_shopping.order;


import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController implements SimpleCrud<Integer, OrderDto> {
    private final OrderService orderService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
        return orderService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<OrderDto> get(@RequestParam Integer id) {
        return orderService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto dto, @RequestParam Integer id) {
        return orderService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<OrderDto> delete(@RequestParam Integer id) {
        return orderService.delete(id);
    }
}

