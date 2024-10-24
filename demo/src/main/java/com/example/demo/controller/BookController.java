package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "This is a book controller
        public class DemoController {
        @GetMapping("/search")
        public List<Book> searchBooks(@RequestParam String keyword) {
    return bookRepository.findAll().stream()
            .filter(book -> book.getTitle().contains(keyword) || book.getAuthor().contains(keyword))
            .collect(Collectors.toList());
}
}