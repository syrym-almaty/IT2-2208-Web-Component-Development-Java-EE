package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "This is a book controller for managing books.")
public class BookController {

    private BookRepository bookRepository;

    public void DemoController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().contains(keyword) || book.getAuthor().contains(keyword))
                .collect(Collectors.toList());
    }
}