package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.CurtidaModel;
import com.example.EcoMomentBD_API.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/curtida", produces = "application/json; charset=UTF-8")
public class CurtidaController {
    @Autowired
    CurtidaRepository curtidaRepo;

    @GetMapping
    public List<CurtidaModel> todos(){
        return curtidaRepo.findAll();
    }

    @GetMapping("/isFavorited/{idUsuarioWeb}/{idPostagem}")
    public Optional<CurtidaModel> isFavorited(@PathVariable int idUsuarioWeb, @PathVariable int idPostagem){
        return curtidaRepo.findByIdUsuarioWebAndIdPostagem(idUsuarioWeb, idPostagem);
    }

    @PostMapping("/curtirFunction/{idPostagem}/{idUsuarioCurtiu_Postagem}/{nomeUsuarioDono_Postagem}")
    @Transactional
    public void curtirPostagem(@PathVariable int idPostagem, @PathVariable int idUsuarioCurtiu_Postagem, @PathVariable String nomeUsuarioDono_Postagem){
        curtidaRepo.curtiuFunction(idPostagem, idUsuarioCurtiu_Postagem);
        curtidaRepo.atualizarNCurtidaPostagemByIdPostagem(idPostagem);
        Integer idUsuarioDono_Postagem = curtidaRepo.buscarIdUsuarioDonoByNomeWeb(nomeUsuarioDono_Postagem);
        if(idUsuarioDono_Postagem != null) {
            curtidaRepo.atualizarNCurtidaUsuarioByIdUsuarioDono(idUsuarioDono_Postagem);
        }
    }

    @PostMapping("/descurtirFunction/{idPostagem}/{idUsuarioCurtiu_Postagem}/{nomeUsuarioDono_Postagem}")
    @Transactional
    public void descurtirPostagem(@PathVariable int idPostagem, @PathVariable int idUsuarioCurtiu_Postagem, @PathVariable String nomeUsuarioDono_Postagem) {
        curtidaRepo.descurtirFunction(idPostagem, idUsuarioCurtiu_Postagem);
        curtidaRepo.atualizarPostagemByDescurtirFunction(idPostagem);
        Integer idUsuarioDono = curtidaRepo.buscarIdUsuarioDonoByNomeWeb(nomeUsuarioDono_Postagem);
        if (idUsuarioDono != null) {
            curtidaRepo.atualizarUsuarioByDescurtirFunction(idUsuarioDono);
        }
    }
}
