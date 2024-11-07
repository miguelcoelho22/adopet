package com.example.adopet_meu_projeto.repository;

import com.example.adopet_meu_projeto.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
