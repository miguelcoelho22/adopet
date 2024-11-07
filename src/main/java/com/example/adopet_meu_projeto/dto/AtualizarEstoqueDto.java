package com.example.adopet_meu_projeto.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AtualizarEstoqueDto(@NotNull  Long id, @NotNull @Min(1) Integer quantidade) {
}
