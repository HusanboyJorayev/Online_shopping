package com.example.online_shopping.user_accounts;

import com.example.online_shopping.simpleCrud.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController implements SimpleCrud<Integer, UserDto> {
    private final UserService userService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<UserDto> get(@RequestParam Integer id) {
        return userService.get(id);
    }

    @GetMapping("/getWithOthers")
    public ResponseEntity<UserDto> getWithOthers(@RequestParam Integer id) {
        return userService.getWithOthers(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto, @RequestParam Integer id) {
        return userService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<UserDto> delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}
