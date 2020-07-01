package test;

import main.CalculaRaiz;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class calculaRaizTest {

    CalculaRaiz raiz;

    @BeforeAll
    void init() {
        raiz = new CalculaRaiz();
    }

    @Test
    public void testePadrao() {
        double[] r1 = raiz.calcula(1, 0, -9);
        assertAll(() -> assertEquals(3, r1[0]),
                () -> assertEquals(-3, r1[1]));

        double[] r2 = raiz.calcula(1, -9, 0);
        assertAll(() -> assertEquals(9, r2[0]),
                () -> assertEquals(0, r2[1]));

        double[] r3 = raiz.calcula(3, -7, 2);
        assertAll(() -> assertEquals(0, r3[0]),
                () -> assertEquals(2, r3[1]));

        double[] r4 = raiz.calcula(-1, 4, -4);
        assertEquals(r1[0], r4[1]);

        assertThrows(RuntimeException.class, () -> {
            double[] r5 = raiz.calcula(3, -1, -2);
        });
    }

    @Test
    public void raizImaginaria() {
        assertThrows(RuntimeException.class, () -> {
            double[] result = raiz.calcula(1, -4, 5);
        });
    }

    @Test
    public void raizIguais() {
        double[] result = raiz.calcula(4, -4, 1);
        assertEquals(result[0], result[1]);
    }

    @Test
    public void raizDiferentes() {
        double[] result = raiz.calcula(1, -5, 6);
        assertAll(() -> assertEquals(result[0], 3),
                () -> assertEquals(result[1], 2));
    }
}