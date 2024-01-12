package com.example.online_shopping.categories;

import com.example.online_shopping.cart.CartDto;
import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "category")
public class CategoryController implements SimpleCrud<Integer, CategoryDto> {
    private final CategoryService categoryService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {
        return categoryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<CategoryDto> get(@RequestParam Integer id) {
        return categoryService.get(id);
    }

    @GetMapping("/getWithProduct")
    public ResponseEntity<CategoryDto> getWithProduct(@RequestParam Integer id) {
        return categoryService.getWithProduct(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto, @RequestParam Integer id) {
        return categoryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<CategoryDto> delete(@RequestParam Integer id) {
        return categoryService.delete(id);
    }
}
