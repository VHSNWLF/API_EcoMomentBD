package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.PostagemModel;
import com.example.EcoMomentBD_API.repository.PostagemRepository;
import com.example.EcoMomentBD_API.service.SalvoService;
import com.example.EcoMomentBD_API.service.SeguindoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/postagem", produces = "application/json; charset=UTF-8")
public class PostagemController {

    @Autowired
    SalvoService salvoService;

    @Autowired
    SeguindoService segService;

    @Autowired
    PostagemRepository postagemRepo;

    @GetMapping
    public List<PostagemModel> todos(){
        return postagemRepo.findAll();
    }

    @GetMapping("/byNomeUsuario/{nome}")
    public List<PostagemModel> byNomeUsuario(@PathVariable String nome){
        return postagemRepo.findByNomeUsuario(nome);
    }

    @GetMapping("/byMaterialPostagem/{materialPostagem}")
    public List<PostagemModel> byMaterialPostagem(@PathVariable String materialPostagem){
        return postagemRepo.findByMaterialPostagem(materialPostagem);
    }

    @GetMapping("/maisAvaliadas")
    public List<PostagemModel> MaisAvaliadas_10(){
        return postagemRepo.ideiasMaisAvaliadas_10();
    }


    @GetMapping("/maisAvaliadas2/{materialPostagem}")
    public List<PostagemModel> MaisAvaliadas(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisAvaliadas( materialPostagem);
    }
    @GetMapping("/maisCurtidas/{materialPostagem}")
    public List<PostagemModel> MaisCurtidas(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisCurtidas(materialPostagem);
    }
    @GetMapping("/maisDificuldade/{materialPostagem}")
    public List<PostagemModel> MaisDificuldade(@PathVariable String materialPostagem){
        return postagemRepo.ideiasMaisDificuldade(materialPostagem);
    }

        @GetMapping("/ideiasByIdPostagem")
    public List<PostagemModel> ideiasByIdPostagem(){
            System.out.println(salvoService.getListaIdPostagem());
        return postagemRepo.listaIdeiasByIdPostagem(salvoService.getListaIdPostagem());
    }

    @GetMapping("/ideiasByNomeWeb")
    public List<PostagemModel> ideiasByNomeWeb(){
        return postagemRepo.listaIdeiasByNomeWeb(segService.getListaNomeUsuarioWebByIdSeguindo());
    }

    @GetMapping("/ideiasByNomeWebOrderByNCurtidas/{nomeWeb}")
    public List<PostagemModel> ideiasByNomeWeb(@PathVariable String nomeWeb){
        return postagemRepo.findByNomeUsuarioOrderByNCurtidas(nomeWeb);
    }

    @GetMapping("/findByNomePostagem/{nomePostagem}")
    public Optional<PostagemModel> findByNomePostagem(@PathVariable String nomePostagem){
        return postagemRepo.findByNomePostagem(nomePostagem);
    }



}
