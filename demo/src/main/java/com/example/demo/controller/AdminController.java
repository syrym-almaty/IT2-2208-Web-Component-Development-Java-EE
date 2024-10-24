package com.example.demo.controller;

<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    // Admin-only endpoints
<<<<<<< HEAD
}
=======
}
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
