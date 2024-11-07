package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoDto(Long id, LocalDate data, List<ItensDto> itens) {

    public PedidoDto(Pedido pedido){
        this(pedido.getId(), pedido.getData(), pedido.getItemPedido().stream().map(ItensDto::new).collect(Collectors.toList()));
    }

}
