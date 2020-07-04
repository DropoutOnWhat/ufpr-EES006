package test;

import model.Cricunferencia;
import model.Retangulo;
import model.Triangulo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CRTTest {

    @Test
    public void testaCirculo() {
        Cricunferencia c = new Cricunferencia(2.5);
        double result = 15.707963267948966;
        assertEquals(result, c.getArea());
    }

    @Test
    public void testaCirculoRuim() {
        assertThrows(RuntimeException.class, () -> {
            Cricunferencia c = new Cricunferencia(-4.9);
        });
    }

    @Test
    public void testaRetangulo() {
        Retangulo r = new Retangulo(2, 6);
        double result = 12;
        assertEquals(result, r.getArea());
    }

    @Test
    public void testaRetanguloRuim() {
        assertAll(() -> assertThrows(RuntimeException.class, () -> {
            Retangulo r = new Retangulo(-2, 5);
        }),
        () -> assertThrows(RuntimeException.class, () -> {
            Retangulo r2 = new Retangulo(7, -4);
        }));
    }

    @Test
    public void testaTriangulo() {
        Triangulo t = new Triangulo(2, 6);
        double result = 6;
        assertEquals(result, t.getArea());
    }

    @Test
    public void testaTrianguloRuim() {
        assertAll(() -> assertThrows(RuntimeException.class, () -> {
                Triangulo t = new Triangulo(-2, 5);
            }),
            () -> assertThrows(RuntimeException.class, () -> {
                Triangulo t = new Triangulo(7, -4);
            }));
    }
}