package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import org.springframework.security.core.GrantedAuthority;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String name;
<<<<<<< HEAD
=======
    @Id
    private Long id;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

    // Implement methods from GrantedAuthority interface

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
<<<<<<< HEAD
}
=======

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
