package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // Endpoinds
    // metodo index
    @GetMapping()
    public String index(){
        return "CONECTAR";
    }

}
