package com.example.postcreating.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id", "email"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Enumerated
    Role role;


}