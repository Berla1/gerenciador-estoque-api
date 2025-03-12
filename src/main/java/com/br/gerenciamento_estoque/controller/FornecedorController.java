package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.model.Fornecedor;
import com.br.gerenciamento_estoque.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllFornecedores(){
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();

        if (fornecedores.isEmpty()){
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se a lista estiver vazia
        }
        return ResponseEntity.ok(fornecedores); // Retorna 200 OK com a lista de produtos
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id){
        Optional<Fornecedor> fornecedorEncontrado = fornecedorRepository.findById(id);
        if(fornecedorEncontrado.isPresent()){
            return ResponseEntity.ok(fornecedorEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
