package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Itens;

import java.util.List;

public record CadastroPedidoDto(List<ItensDto> itensList) {
}
