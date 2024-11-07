package com.example.adopet_meu_projeto.controller;

import com.example.adopet_meu_projeto.dto.AtualizarEstoqueDto;
import com.example.adopet_meu_projeto.dto.EstoqueDto;
import com.example.adopet_meu_projeto.service.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;
    @GetMapping
    public ResponseEntity<List<EstoqueDto>> listar(){
        List<EstoqueDto> estoqueDto = service.listar();
        return new ResponseEntity<>(estoqueDto, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EstoqueDto> atualizar (@RequestBody AtualizarEstoqueDto dto){
        EstoqueDto estoqueDto = service.atualizar(dto);
        return new ResponseEntity<>(estoqueDto, HttpStatus.OK);
    }



}
