package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public Pedido(String nomeCliente, List<ItemDoPedido> itens, double limite) {
        this.nomeCliente = nomeCliente;
        this.itens = itens;
        this.limite = limite;
    }

    private String nomeCliente;
    private List<ItemDoPedido> itens;
    private double limite = 0;

    public void adicionarItem(ItemDoPedido i) {
        if(this.limite == 0) {
            throw new RuntimeException("Cliente não tem nenhum credito.");
        }
        if(this.itens == null) {
            ArrayList<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
            this.setItens(itens);
        }
        if(i != null) {
            if(novoTotal(i) > limite) {
                throw new RuntimeException("Valor limite excedido. Item " + i.getNome() + " não será adicionado");
            }
            if(this.itens.contains(i)) {
                somaItem(i);
            } else {
                this.itens.add(i);
            }
        } else {
            throw new RuntimeException("Impossível adicionar item nulo.");
        }
    }

    public void removeItem(ItemDoPedido i) {
        if(this.itens.contains(i)) {
            this.itens.remove(i);
        } else {
            throw new RuntimeException("“Item não encontrado no pedido.");
        }
    }

    public double getTotal() {
        double total = 0;
        for(ItemDoPedido each : this.itens) {
            total += (each.getPreco() * each.getQuantia());
        }
        return total;
    }

    public double getSaldoDisponivel() {
        return this.limite - getTotal();
    }

    private void somaItem(ItemDoPedido i) {
        for(ItemDoPedido each : this.itens) {
            if(each.getNome().equals(i.getNome())) {
                each.somaUm();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder cupom = new StringBuilder();
        for(ItemDoPedido each : getItens()) {
            cupom.append("     '-- Item: ")
                .append(each.getNome())
                .append("     -- Preço: ")
                .append(each.getPreco())
                .append("     -- Quantia: ")
                .append(each.getQuantia())
                .append("\n");
        }
        return cupom.toString();
    }

    private StringBuilder listaItens() {
        if(getItens().isEmpty()) {
            return null;
        } else {
            StringBuilder lista = new StringBuilder();
            for(ItemDoPedido each : this.getItens()) {
                lista.append(each.getNome()).append("------------------------- ").append(each.getPreco()).append("\n");
            }
            return lista;
        }
    }

    private double novoTotal(ItemDoPedido i) {
        double valorPedido =  i.getPreco() * i.getQuantia();
        return valorPedido + getTotal();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
