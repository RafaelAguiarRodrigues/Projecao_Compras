package br.com.projecao.model;

import jakarta.persistence.*;

@Entity
@Table(name= "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorCompra;
    private String nomeCompra;

    Compra() {}

    public Compra(DadosCompra dados) {
        this.nomeCompra = dados.nomeCompra();
        this.valorCompra = dados.valorCompra();
    }

    public void atualizarDados (DadosAlteracaoCompra dados) {
        this.valorCompra = dados.valorCompra();
        this.nomeCompra = dados.nomeCompra();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getNomeCompra() {
        return nomeCompra;
    }

    public void setNomeCompra(String nomeCompra) {
        this.nomeCompra = nomeCompra;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "valor Compra=" + valorCompra +
                ", nome Compra='" + nomeCompra + '\'' +
                '}';
    }
}
