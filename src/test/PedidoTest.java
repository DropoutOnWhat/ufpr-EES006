package test;

import model.ItemDoPedido;
import model.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PedidoTest {

    @Test
    public void adicionaItens() {
        ItemDoPedido i = new ItemDoPedido("Vinho", 35.50, 1);
        ItemDoPedido i1 = new ItemDoPedido("Cerveja", 3.69, 12);
        ItemDoPedido i2 = new ItemDoPedido("Vodka", 40, 1);
        Pedido pedido = new Pedido("Regis", null, 100.00);
        pedido.adicionarItem(i);
        pedido.adicionarItem(i1);
        pedido.adicionarItem(i2);
        System.out.println(pedido.toString());
        assertNotNull(pedido.getItens());
    }

}