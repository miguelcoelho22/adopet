package com.example.adopet_meu_projeto.service;

import com.example.adopet_meu_projeto.domain.Itens;
import com.example.adopet_meu_projeto.domain.Pedido;
import com.example.adopet_meu_projeto.dto.CadastroPedidoDto;
import com.example.adopet_meu_projeto.dto.ItensDto;
import com.example.adopet_meu_projeto.dto.PedidoDto;
import com.example.adopet_meu_projeto.exception.ValidacaoException;
import com.example.adopet_meu_projeto.repository.EstoqueRepository;
import com.example.adopet_meu_projeto.repository.PedidoRepository;
import com.example.adopet_meu_projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    public PedidoDto cadastrar(CadastroPedidoDto dto) {
        ArrayList<Itens> arrayItens = new ArrayList<>();
        for(ItensDto item : dto.itensList()) {
            var estoque = estoqueRepository.findByProdutoId(item.produtoId());
            if(estoque.getQuantidade() >= item.quantidade()){
                var produto = produtoRepository.findById(item.produtoId()).get();
                if(!produto.getAtivo()){
                    throw new ValidacaoException("produto inativo no momento");
                }
                Itens itens = new Itens(produto,null, item.quantidade());
                arrayItens.add(itens);
                estoque.diminuir(item.quantidade());
            }
            else {
                throw new ValidacaoException("estoque indisponivel para o produto");
            }
        }
    Pedido pedido = new Pedido(arrayItens);
        pedidoRepository.save(pedido);
    return new PedidoDto(pedido);
    }
}
