package com.example.adopet_meu_projeto.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Itens> itemPedido = new ArrayList<>();

    public Pedido(ArrayList<Itens> arrayItens) {
        this.data = LocalDate.now();
        this.itemPedido = arrayItens;
        this.itemPedido.forEach(i -> i.setPedido(this));
    }
}
