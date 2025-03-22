package com.example.SUAMAE.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class welcome {
    @GetMapping
    public  String welcome(){
        return "Bem-Vindo :)";
    }
}
