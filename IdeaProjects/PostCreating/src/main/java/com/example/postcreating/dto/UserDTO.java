package com.example.postcreating.dto;


import com.example.postcreating.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id", "email"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id;

    String name;

    String email;

    Role role;
}
