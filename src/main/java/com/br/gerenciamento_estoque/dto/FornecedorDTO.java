package com.br.gerenciamento_estoque.dto;

import com.br.gerenciamento_estoque.model.Produto;

import java.util.List;

public record FornecedorDTO(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        List<Produto> produtos
) {
}
