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
        @Autowired
        private BookService bookService;

        @GetMapping
        public List<Book> getAllBooks() {
        return bookService.getAllBooks();
        }

        @PostMapping
        public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
            Book book = bookService.getBookById(id);
            if (book != null) {
                return ResponseEntity.ok(book);
                }
            return ResponseEntity.notFound().build();
            }

@PutMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable UUID id, @RequestBody Book bookDetails) {
    Book updatedBook = bookService.updateBook(id, bookDetails);
    if (updatedBook != null) {
        return ResponseEntity.ok(updatedBook);
    }
    return ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
}

        @GetMapping("/search")
        public List<Book> searchBooks(@RequestParam String keyword) {
            return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().contains(keyword) || book.getAuthor().contains(keyword))
                .collect(Collectors.toList());
    }
}
