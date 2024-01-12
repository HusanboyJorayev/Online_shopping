package com.example.online_shopping.user_types;


import com.example.online_shopping.user_accounts.UserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {

    private Integer id;
    @NotBlank
    private String name;
    private String description;

    private List<UserDto> users;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
