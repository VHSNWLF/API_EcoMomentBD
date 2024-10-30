package com.example.EcoMomentBD_API.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguindoService {
    private List<Integer> listaIdUsuarioSeguindo;
    private List<String> listaNomeUsuarioWebByIdSeguindo;

    public List<String> getListaNomeUsuarioWebByIdSeguindo() {
        return listaNomeUsuarioWebByIdSeguindo;
    }

    public void setListaNomeUsuarioWebByIdSeguindo(List<String> listaNomeUsuarioWebByIdSeguindo) {
        this.listaNomeUsuarioWebByIdSeguindo = listaNomeUsuarioWebByIdSeguindo;
    }

    public List<Integer> getListaIdUsuarioSeguindo() {
        return listaIdUsuarioSeguindo;
    }

    public void setListaIdUsuarioSeguindo(List<Integer> listaIdPostagem) {
        this.listaIdUsuarioSeguindo = listaIdPostagem;
    }
}
