package main;

import model.ItemDoPedido;
import model.Pedido;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaPedidos {
    List<Pedido> pedidos = null;
    Scanner scan = new Scanner(System.in);
    int op = 0;
    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
        sistema.iniciarSistema();
    }

    public void iniciarSistema() {
        setPedidos(new ArrayList<>());
        System.out.println("#----------- Bem Vindo -----------#");
        System.out.println("Opções disponiveis: \n" +
                "1: Incluir pedido \n" +
                "2: Excluir pedido de um cliente \n" +
                "3: Listar todos os pedidos \n" +
                "4: Adicionar item a um pedido \n" +
                "5: Remover item de um pedido \n" +
                "6: Listar pedidos com detalhes \n" +
                "9: Listar Opções novamente \n" +
                "0: Sair e encerrar o sistema.");
        System.out.print("Informe a opção desejada: ");
        op = scan.nextInt();

        while(op > 0) {
            switch (op) {
                case 1:
                    try {
                        novoPedido();
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 2:
                    try {
                        excluirPedido();
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 3:
                    try {
                        listarPedidos();
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 4:
                    try {
                        adicionarItemAoPedido();
                    }  catch (InputMismatchException ime) {
                        System.out.println("Valor com formatação incorreta. Tente novamente.");
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 5:
                    try {
                        excluirItemDoPedido();
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 6:
                    try {
                        imprimirPedidos();
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    } finally {
                        System.out.print("Informe a opção desejada: ");
                        op = scan.nextInt();
                        continue;
                    }
                case 9:
                    System.out.println("Opções disponiveis: \n" +
                            "1: Incluir pedido \n" +
                            "2: Excluir pedido de um cliente \n" +
                            "3: Listar todos os pedidos \n" +
                            "4: Adicionar item a um pedido \n" +
                            "5: Remover item de um pedido \n" +
                            "6: Listar pedidos com detalhes \n" +
                            "9: Listar Opções novamente \n" +
                            "0: Sair e encerrar o sistema.");
                    System.out.print("Informe a opção desejada: ");
                    op = scan.nextInt();
                    continue;
                default:
                    System.out.println("Opção não reconhecida, tente novamente.");
                    System.out.print("Informe a opção desejada: ");
                    op = scan.nextInt();
                    continue;
            }
        }
        System.out.println("Encerrando sistema. Até logo.");
    }

    public void novoPedido() {
        boolean sucesso = false;
        System.out.print("Informe o nome do cliente: ");
        String nome = scan.next();
        System.out.print("Informe o limite de credito do cliente: ");
        double limite = scan.nextDouble();
        if(getPedidos().isEmpty()) {
            List<ItemDoPedido> itens = new ArrayList<>();
            Pedido novo = new Pedido(nome, itens, limite);
            getPedidos().add(novo);
            sucesso = true;
            System.out.println("Pedido criado com sucesso.");
        } else {
            for(Pedido each : getPedidos()) {
                if (each.getNomeCliente().equals(nome)) {
                    sucesso = true;
                    System.out.println("Pedido já existente para o/a cliente " + nome);
                }
            }
            if (!sucesso) {
                List<ItemDoPedido> itens = new ArrayList<>();
                Pedido novo = new Pedido(nome, itens, limite);
                getPedidos().add(novo);
                System.out.println("Pedido criado com sucesso.");
            }
        }
        if(!sucesso) {
            System.out.println("Algo deu errado ao criar o novo pedido");
        }
    }

    private void excluirPedido() {
        if(this.pedidos == null || this.pedidos.isEmpty()) {
            throw new RuntimeException("Impossível excluir pedidos: Nenhum pedido encontrado.");
        }
        boolean sucesso = false;
        System.out.print("Informe o nome do cliente: ");
        String nome = scan.next();

        for(Pedido each : getPedidos()) {
            if(each.getNomeCliente().equals(nome)) {
                getPedidos().remove(each);
                sucesso = true;
                System.out.println("Pedido do cliente " + nome + " excluído com sucesso");
            }
        }
        if (!sucesso) {
           throw new RuntimeException("Nenhum pedido encontrado para o/a cliente " + nome);
        }
    }

    private void excluirItemDoPedido() {
        if(this.pedidos == null || this.pedidos.isEmpty()) {
            throw new RuntimeException("Impossível excluir itens: Nenhum pedido encontrado.");
        }
        boolean sucesso = false;
        System.out.print("Informe o nome do cliente: ");
        String nome = scan.next();
        System.out.print("Informe o nome do item: ");
        String item = scan.next();
        for(Pedido eachPedido : this.pedidos) {
            if(eachPedido.getNomeCliente().equals(nome)) {
                for(ItemDoPedido eachItem: eachPedido.getItens()) {
                    if (eachItem.getNome().equals(item)) {
                        eachPedido.removeItem(eachItem);
                        sucesso = true;
                        System.out.println("Item removido com sucesso.");
                    } else {
                        throw new RuntimeException("Impossível excluír item. Este item não existe no pedido deste cliente.");
                    }
                }
            }
            if (!sucesso) {
                throw new RuntimeException("Nenhum pedido encontrado para o/a cliente " + nome);
            }
        }
    }

    private void adicionarItemAoPedido() {
        boolean sucesso = false;
        System.out.print("Informe o nome do cliente: ");
        String nome = scan.next();
        System.out.print("Informe o nome do item: ");
        String item = scan.next();
        System.out.print("Informe o preco do item: ");
        double preco = Double.valueOf(scan.next());
        System.out.print("Informe quantos itens devem ser adicionados: ");
        int quantia = scan.nextInt();
        List<ItemDoPedido> itens = new ArrayList<>();
        ItemDoPedido i = new ItemDoPedido(item, preco, quantia);
        if(getPedidos().isEmpty()) {
            System.out.println("Lista de Pedidos vazia, adicionando primeiro pedido.");
            Pedido novo = new Pedido(nome, itens, (i.getPreco() * i.getQuantia()));
            novo.adicionarItem(i);
            getPedidos().add(novo);
            System.out.println("Novo pedido criado. Item adicionado com sucesso.");
        } else {
            for(Pedido each : getPedidos()) {
                if (each.getNomeCliente().equals(nome)) {
                    each.adicionarItem(i);
                    sucesso = true;
                    System.out.println("Item adicionado com sucesso.");
                }
            }
            if (!sucesso) {
                System.out.println("Cliente não encontrado. Criando pedido para adicionar o item.");
                itens.add(i);
                Pedido novo = new Pedido(nome, itens, (i.getPreco() * i.getQuantia()));
                getPedidos().add(novo);
                System.out.println("Pedido com o item adicionado com sucesso.");
            }
        }
    }

    private void listarPedidos() {
        if(getPedidos() == null || getPedidos().isEmpty()) {
            throw new RuntimeException("Nenhum pedido encontrado.");
        }
        StringBuilder cupom = new StringBuilder();
        cupom.append("#----------- Lista de Pedidos -----------#").append("\n");
        for(Pedido each : getPedidos()) {
            cupom.append("Cliente: ").append(each.getNomeCliente())
                    .append(" ***** Limite total: ").append(each.getLimite())
                    .append(" ***** Limite disponível: ").append(each.getSaldoDisponivel())
                    .append("\n");
        }
        cupom.append("#-----------       *****       -----------#");
        System.out.println(cupom.toString());
    }

    private void imprimirPedidos() {
        if(this.pedidos == null || this.pedidos.isEmpty()) {
            throw new RuntimeException("Nenhum pedido encontarado.");
        }
        StringBuilder cupom = new StringBuilder();
        cupom.append("#----------- Lista de Pedidos -----------#").append("\n");
        for(Pedido each : this.pedidos) {
            cupom.append("Cliente: ").append(each.getNomeCliente())
                    .append(" ***** Limite total: ").append(each.getLimite())
                    .append(" ***** Limite disponível: ").append(each.getSaldoDisponivel()).append("\n")
                    .append(each.toString())
                    .append("\n");
        }
        cupom.append("#-----------       *****       -----------#");
        System.out.println(cupom.toString());
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
