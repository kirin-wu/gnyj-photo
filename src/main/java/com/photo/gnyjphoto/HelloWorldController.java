package com.photo.gnyjphoto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "hello world!";
    }
}
