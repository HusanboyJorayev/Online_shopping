package com.example.online_shopping.products;

import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController implements SimpleCrud<Integer, ProductDto> {
    private final ProductService productService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<ProductDto> get(@RequestParam Integer id) {
        return productService.get(id);
    }

    @GetMapping("/getWithCartAndProduct")
    public ResponseEntity<ProductDto> getWithCartAndProduct(@RequestParam Integer id) {
        return productService.getWithCartAndPayment(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto, @RequestParam Integer id) {
        return productService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<ProductDto> delete(@RequestParam Integer id) {
        return productService.delete(id);
    }
}
