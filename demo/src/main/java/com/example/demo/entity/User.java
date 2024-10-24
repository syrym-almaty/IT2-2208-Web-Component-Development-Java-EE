package com.example.demo.entity;

<<<<<<< HEAD
import jakarta.persistence.*;

import java.util.Set;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.userdetails.UserDetails;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

@Entity
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_username"),
            inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Role> roles;
<<<<<<< HEAD
=======
    @Id
    private Long id;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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
