package com.br.gerenciamento_estoque.repository;

import com.br.gerenciamento_estoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
