package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.model.Produto;
import com.br.gerenciamento_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
