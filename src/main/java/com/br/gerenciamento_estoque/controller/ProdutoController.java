package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.dto.ProdutoDTO;
import com.br.gerenciamento_estoque.model.Produto;
import com.br.gerenciamento_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping()
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public void cadastrarProduto(@RequestBody ProdutoDTO produto){
        Produto novoProduto = new Produto(produto);
        produtoRepository.save(novoProduto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id){
        produtoRepository.deleteById(id);
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
