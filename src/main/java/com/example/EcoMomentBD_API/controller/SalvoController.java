package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.SalvoModel;
import com.example.EcoMomentBD_API.repository.SalvoRepository;
import com.example.EcoMomentBD_API.service.SalvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/salvos", produces = "application/json; charset=UTF-8")
public class SalvoController {

    @Autowired
    SalvoService salvoService;

    public SalvoController() {
    }

    @Autowired
    SalvoRepository salvoRepo;

    @GetMapping()
    public List<SalvoModel> todos(){
        return salvoRepo.findAll();
    }

    @GetMapping("/isSaved/{idUsuarioWeb}/{idPostagem}")
    public Optional<SalvoModel> isSaved (@PathVariable int idUsuarioWeb, @PathVariable int idPostagem){
        return salvoRepo.isSaved(idUsuarioWeb, idPostagem);
    }

    @GetMapping("/ByIdUsuarioWeb/{id}")
    public List<Integer> byIdUsuarioWeb(@PathVariable int id){
        salvoService.setListaIdPostagem(salvoRepo.findByIdUsuarioWeb(id));
        System.out.println(salvoService.getListaIdPostagem());
        return salvoRepo.findByIdUsuarioWeb(id);
    }

    @PostMapping("/save/{idUsuarioWeb}/{idPostagem}")
    @Transactional
    public void addSaved(@PathVariable int idUsuarioWeb, @PathVariable int idPostagem){
        salvoRepo.save(idUsuarioWeb, idPostagem);
    }

    @PostMapping("/delete/{idUsuarioWeb}/{idPostagem}")
    @Transactional
    public void deleteSaved(@PathVariable int idUsuarioWeb, @PathVariable int idPostagem){
        salvoRepo.delete(idUsuarioWeb, idPostagem);
    }

}
