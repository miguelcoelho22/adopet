package com.example.adopet_meu_projeto.controller;

import com.example.adopet_meu_projeto.dto.CadastroPedidoDto;
import com.example.adopet_meu_projeto.dto.PedidoDto;
import com.example.adopet_meu_projeto.service.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> cadastrar(@RequestBody CadastroPedidoDto dto){
        PedidoDto pedido = pedidoService.cadastrar(dto);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

}
