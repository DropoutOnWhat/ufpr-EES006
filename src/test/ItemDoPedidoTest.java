package test;

import model.ItemDoPedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemDoPedidoTest {

    @Test
    public void testaItemBom() {
        ItemDoPedido i = new ItemDoPedido("Socorro", 19.90, 1);
        assertNotNull(i);
    }

    @Test
    public void testaItemRuim() {
        assertThrows(RuntimeException.class, () -> {
            ItemDoPedido i = new ItemDoPedido("", -40.9, 0);
        });
    }

    @Test
    public void testaPreco() {
        assertThrows(RuntimeException.class, () -> {
           ItemDoPedido i = new ItemDoPedido("Cerveja", -3.69, 12);
        });
    }
}