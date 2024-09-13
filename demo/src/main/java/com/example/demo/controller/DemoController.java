package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    // Simple GET request
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, Swagger!";
    }

    // GET request that returns JSON response
    @GetMapping("/greet")
    public Greeting greetUser() {
        return new Greeting("Greetings from the Demo Controller!", "Have a great day!");
    }

    // POST request that accepts JSON data and returns a message
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return new User(user.getName(), user.getEmail());
    }
}

// A simple POJO class to return a greeting message as JSON
class Greeting {
    private String message;
    private String note;

    public Greeting(String message, String note) {
        this.message = message;
        this.note = note;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

// A simple POJO class representing a User
class User {
    private String name;
    private String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
