package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Itens;
import com.example.adopet_meu_projeto.domain.Produto;
import jakarta.mail.FetchProfile;

public record ItensDto(Long produtoId, Integer quantidade) {

    public ItensDto(Itens itens){
        this(itens.getPedido().getId(), itens.getQuantidade());
    }
}
