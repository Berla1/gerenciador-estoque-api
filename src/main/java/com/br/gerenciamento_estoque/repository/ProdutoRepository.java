package com.br.gerenciamento_estoque.repository;

import com.br.gerenciamento_estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
