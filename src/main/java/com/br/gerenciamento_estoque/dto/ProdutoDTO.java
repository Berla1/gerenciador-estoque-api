package com.br.gerenciamento_estoque.dto;

import com.br.gerenciamento_estoque.model.Fornecedor;

public record ProdutoDTO(String nome,
                         Double preco,
                         Integer quantidade_estoque,
                         String fabricante,
                         String codigo_barras,
                         Fornecedor fornecedor) {
}
