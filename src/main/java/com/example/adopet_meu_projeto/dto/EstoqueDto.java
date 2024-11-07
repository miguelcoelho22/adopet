package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Estoque;
import com.example.adopet_meu_projeto.domain.Produto;

public record EstoqueDto(Long id, Integer quantidade, Produto produto) {

    public EstoqueDto(Estoque estoque){
        this(estoque.getId(), estoque.getQuantidade(), estoque.getProduto());
    }
}
