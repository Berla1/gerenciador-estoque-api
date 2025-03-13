package com.br.gerenciamento_estoque.model;

import com.br.gerenciamento_estoque.dto.FornecedorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    public Fornecedor(){}

    public Fornecedor(FornecedorDTO fornecedor) {
        this.nome = fornecedor.nome();
        this.cnpj = fornecedor.cnpj();
        this.telefone = fornecedor.telefone();
    }

    public Long getId() {
        return id;
    }

    public Fornecedor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Fornecedor setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Fornecedor setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Fornecedor setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

}
