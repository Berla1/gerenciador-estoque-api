package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.dto.FornecedorDTO;
import com.br.gerenciamento_estoque.model.Fornecedor;
import com.br.gerenciamento_estoque.model.Produto;
import com.br.gerenciamento_estoque.repository.FornecedorRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody FornecedorDTO fornecedor){
        Fornecedor novoFornecedor = new Fornecedor(fornecedor);
        fornecedorRepository.save(novoFornecedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoFornecedor); // Retorna 201 Created com o produto criado
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atulizarFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO fornecedor){
        Fornecedor fornecedorAtualizado = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        fornecedorAtualizado.setNome(fornecedor.nome());
        fornecedorAtualizado.setCnpj(fornecedor.cnpj());
        fornecedorAtualizado.setTelefone(fornecedor.telefone());

        fornecedorRepository.save(fornecedorAtualizado);

        return ResponseEntity.ok(fornecedorAtualizado); // Retorna 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable Long id){
         if (!fornecedorRepository.existsById(id)){
             return ResponseEntity.notFound().build(); // Retorna 404 se o produto não existir
         } else {
             fornecedorRepository.deleteById(id);
             return ResponseEntity.noContent().build(); // Retorna 204 No Content após a exclusão
         }
    }
}
