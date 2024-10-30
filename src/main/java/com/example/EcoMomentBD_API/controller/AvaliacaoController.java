package com.example.EcoMomentBD_API.controller;

import com.example.EcoMomentBD_API.model.AvaliacaoModel;
import com.example.EcoMomentBD_API.model.SalvoModel;
import com.example.EcoMomentBD_API.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/Ecomoment/avaliacao", produces = "application/json; charset=UTF-8")
public class AvaliacaoController {
    @Autowired
    AvaliacaoRepository avaliacaoRepo;
    @GetMapping
    public List<AvaliacaoModel> todos(){
        return avaliacaoRepo.findAll();
    }

    @GetMapping("/isRated/{idPostagem}/{idUsuarioWeb}")
    public Optional<AvaliacaoModel> isRated(@PathVariable int idPostagem, @PathVariable int idUsuarioWeb){
        return avaliacaoRepo.isRated(idPostagem, idUsuarioWeb);
    }

    @PostMapping("/avaliar/{idUsuarioWeb}/{idPostagem}/{valor}/{nomeUsuarioDono}")
    @Transactional
    public void avaliar(@PathVariable int idUsuarioWeb, @PathVariable int idPostagem, @PathVariable int valor, @PathVariable String nomeUsuarioDono){
        System.out.println("Avaliando...");
        System.out.println("Valor recebido do flutter: "+valor);
        avaliacaoRepo.saveAvaliacao(idPostagem, idUsuarioWeb, valor);
        avaliacaoRepo.atualizarQtdeAvaliacoesPostagem(idPostagem);
        float qtd = avaliacaoRepo.countUsuariosWeb(idPostagem);
        System.out.println("Quantidade: " + qtd);
        float soma = avaliacaoRepo.somaValorAvaliacao(idPostagem);
        System.out.println("Soma: " + soma);
        float media = soma/qtd;
        System.out.println("Média: " + media);
        avaliacaoRepo.atualizarMediaAvaliacaoPostagem(media, idPostagem);

        //segunda parte
        float qtdPostagens = avaliacaoRepo.countPostagensPorUsuario(nomeUsuarioDono);
        System.out.println("qtdPostagens do usuario " + nomeUsuarioDono + ": " + qtdPostagens);
        float somaAv = avaliacaoRepo.somaAvaliacaoPostagem(nomeUsuarioDono);
        System.out.println("SomaAvaliação Postagens do usuario " + nomeUsuarioDono + ": " + somaAv);
        float media2 = somaAv/qtdPostagens;
        System.out.println("Reputação do usuario " + nomeUsuarioDono + ": " + media2);
        avaliacaoRepo.atualizarReputacaoUsuario(media2, nomeUsuarioDono);
    }

    @PostMapping("/reavaliar/{idUsuarioWeb}/{idPostagem}/{valor}/{nomeUsuarioDono}")
    @Transactional
    public void reavaliar(@PathVariable int idUsuarioWeb, @PathVariable int idPostagem, @PathVariable int valor, @PathVariable String nomeUsuarioDono){
        System.out.println("Reavaliando...");
        avaliacaoRepo.atualizarValor(valor, idPostagem, idUsuarioWeb);
        float qtd = avaliacaoRepo.countUsuariosWeb(idPostagem);
        System.out.println("Quantidade: " + qtd);
        float soma = avaliacaoRepo.somaValorAvaliacao(idPostagem);
        System.out.println("Soma: " + soma);
        float media = soma/qtd;
        System.out.println("Média: " + media);
        avaliacaoRepo.atualizarMediaAvaliacaoPostagem(media, idPostagem);

        //segunda parte
        float qtdPostagens = avaliacaoRepo.countPostagensPorUsuario(nomeUsuarioDono);
        System.out.println("qtdPostagens do usuario " + nomeUsuarioDono + ": " + qtdPostagens);
        float somaAv = avaliacaoRepo.somaAvaliacaoPostagem(nomeUsuarioDono);
        System.out.println("SomaAvaliação Postagens do usuario " + nomeUsuarioDono + ": " + somaAv);
        float media2 = somaAv/qtdPostagens;
        System.out.println("Reputação do usuario " + nomeUsuarioDono + ": " + media2);
        avaliacaoRepo.atualizarReputacaoUsuario(media2, nomeUsuarioDono);
    }
}
