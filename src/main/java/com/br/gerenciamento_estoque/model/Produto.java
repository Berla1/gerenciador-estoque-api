package com.br.gerenciamento_estoque.model;

import com.br.gerenciamento_estoque.dto.ProdutoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade_estoque;
    private String fabricante;
    private String codigo_barras;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    public Produto(){}

    public Produto(ProdutoDTO produto) {
        this.nome = produto.nome();
        this.preco = produto.preco();
        this.quantidade_estoque = produto.quantidade_estoque();
        this.fabricante = produto.fabricante();
        this.codigo_barras = produto.codigo_barras();
        this.fornecedor = produto.fornecedor();
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getPreco() {
        return preco;
    }

    public Produto setPreco(Double preco) {
        this.preco = preco;
        return this;
    }

    public Integer getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public Produto setQuantidade_estoque(Integer quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
        return this;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Produto setFabricante(String fabricante) {
        this.fabricante = fabricante;
        return this;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public Produto setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
        return this;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Produto setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        return this;
    }
}
