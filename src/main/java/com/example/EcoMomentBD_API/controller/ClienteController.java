package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.Cliente;
import com.example.EcoMomentBD_API.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/Cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clRepo;

    @GetMapping("/todos")
    public List<Cliente> todos(){
        return clRepo.findAll();
    }
}
