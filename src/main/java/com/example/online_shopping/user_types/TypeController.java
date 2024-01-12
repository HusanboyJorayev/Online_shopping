package com.example.online_shopping.user_types;

import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("type")
public class TypeController implements SimpleCrud<Integer, TypeDto> {
    private final TypeService typeService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TypeDto> create(@RequestBody TypeDto dto) {
        return typeService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<TypeDto> get(@RequestParam Integer id) {
        return typeService.get(id);
    }

    @GetMapping("/getWithUser")
    public ResponseEntity<TypeDto> getWithUser(@RequestParam Integer id) {
        return typeService.getWithUser(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<TypeDto> update(@RequestBody TypeDto dto, @RequestParam Integer id) {
        return typeService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<TypeDto> delete(@RequestParam Integer id) {
        return typeService.delete(id);
    }
}
