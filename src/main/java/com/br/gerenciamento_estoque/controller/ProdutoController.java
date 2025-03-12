package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.dto.ProdutoDTO;
import com.br.gerenciamento_estoque.model.Produto;
import com.br.gerenciamento_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se a lista estiver vazia
        }
        return ResponseEntity.ok(produtos); // Retorna 200 OK com a lista de produtos
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto novoProduto = new Produto(produtoDTO);
        Produto produtoSalvo = produtoRepository.save(novoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo); // Retorna 201 Created com o produto criado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não existir
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após a exclusão
    }


    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        produto.setNome(produtoDTO.nome());
        produto.setPreco(produtoDTO.preco());
        produto.setQuantidade_estoque(produtoDTO.quantidade_estoque());
        produto.setFabricante(produtoDTO.fabricante());
        produto.setFornecedor(produtoDTO.fornecedor());
        produto.setCodigo_barras(produtoDTO.codigo_barras());

        produtoRepository.save(produto);

        return ResponseEntity.ok(produto);
    }




}
