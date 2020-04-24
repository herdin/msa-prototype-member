package com.jsm.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    //
    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id) {
        return "hello-" + id;
    }

}
