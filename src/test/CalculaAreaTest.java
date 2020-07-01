package test;

import main.CalculaArea;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculaAreaTest {

    CalculaArea calculator;

    @BeforeAll
    void init() {
        calculator = new CalculaArea();
    }

    @Test
    public void operacaoRuim() {
        double result = calculator.calcula(1, 1, 5);
        assertEquals(result, 404);
    }

    @Test
    public void retanguloTesteBom() {
        Double result = calculator.calculaRetangulo(2.0, 2.0);
        assertAll(() -> assertTrue(result > 0),
                () -> assertEquals(4.0, result));
    }

    @Test
    public  void retanguloTesteNegativo() {
        assertThrows(RuntimeException.class, () -> {
            Double result = calculator.calculaRetangulo(-2.0, 3.0);
        });
    }

    @Test
    public  void retanguloTesteZero() {
        assertThrows(RuntimeException.class, () -> {
            Double result = calculator.calculaRetangulo(0.0, 3.0);
        });
    }
}