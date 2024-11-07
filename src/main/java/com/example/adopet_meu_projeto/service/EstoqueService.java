package com.example.adopet_meu_projeto.service;

import com.example.adopet_meu_projeto.domain.Estoque;
import com.example.adopet_meu_projeto.domain.Produto;
import com.example.adopet_meu_projeto.dto.AtualizarEstoqueDto;
import com.example.adopet_meu_projeto.dto.EstoqueDto;
import com.example.adopet_meu_projeto.exception.ValidacaoException;
import com.example.adopet_meu_projeto.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;
    public List<EstoqueDto> listar() {
        return estoqueRepository.findAll().stream().map(EstoqueDto::new).collect(Collectors.toList());
    }

    public EstoqueDto atualizar(AtualizarEstoqueDto dto) {
        Estoque estoque = estoqueRepository.findByProdutoId(dto.id());
        if(!estoque.getProduto().getAtivo()){
            throw new ValidacaoException("produto nao disponivel");
        }
        estoque.adicionar(dto.quantidade());

        return new EstoqueDto(estoque);
    }
}
