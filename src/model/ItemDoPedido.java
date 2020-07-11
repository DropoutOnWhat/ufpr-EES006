package model;

import org.junit.platform.commons.util.StringUtils;

public class ItemDoPedido {
    public ItemDoPedido(String nome, double preco, int quantia) {
        if(StringUtils.isBlank(nome)) {
            throw new RuntimeException("O nome do produto deve ser informado.");
        }
        if(0 > preco || 0 >= quantia) {
            throw new RuntimeException("o Preço e/ou quantia devem ser maiores que zero.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantia = quantia;
    }

    private String nome;
    private double preco;
    private int quantia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantia() {
        return quantia;
    }

    public void setQuantia(int quantia) {
        this.quantia = quantia;
    }

    public void somaUm() {
        this.quantia += 1;
    }
}
