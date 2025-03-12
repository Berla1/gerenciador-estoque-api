package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.dto.ProdutoDTO;
import com.br.gerenciamento_estoque.model.Produto;
import com.br.gerenciamento_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
