package com.example.EcoMomentBD_API.service;

import com.example.EcoMomentBD_API.model.SalvoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalvoService {
    private List<Integer> listaIdPostagem;

    public List<Integer> getListaIdPostagem() {
        return listaIdPostagem;
    }

    public void setListaIdPostagem(List<Integer> listaIdPostagem) {
        this.listaIdPostagem = listaIdPostagem;
    }
}
