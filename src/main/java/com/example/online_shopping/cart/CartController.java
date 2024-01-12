package com.example.online_shopping.cart;

import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController implements SimpleCrud<Integer, CartDto> {
    private final CartService cartService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<CartDto> create(@RequestBody CartDto dto) {
        return cartService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<CartDto> get(@RequestParam Integer id) {
        return cartService.get(id);
    }

    @GetMapping("/getWithOrder")
    public ResponseEntity<CartDto> getWithOrder(@RequestParam Integer id) {
        return cartService.getWithOrder(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<CartDto> update(@RequestBody CartDto dto, @RequestParam Integer id) {
        return cartService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<CartDto> delete(@RequestParam Integer id) {
        return cartService.delete(id);
    }
}
