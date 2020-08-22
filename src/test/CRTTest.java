package test;

import model.Forma;
import model.Cricunferencia;
import model.Retangulo;
import model.Triangulo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CRTTest {

    @Test
    public void testaFormaCirculo() {
        Forma c = new Cricunferencia(1);
        c.setMedida(1, 2.5);
        double result = c.area();
        double expected = 15.707963267948966;
        assertEquals(expected, result);
    }

    @Test
    public void testaFormaRetangulo() {
        Forma r = new Retangulo(2);
        r.setMedida(1, 2);
        r.setMedida(2, 6);
        double result = r.area();
        double expected = 12;
        assertEquals(expected, result);
    }

    @Test
    public void testaFormaTriangulo() {
        Forma t = new Triangulo(2);
        t.setMedida(1, 2);
        t.setMedida(2, 6);
        double result = t.area();
        double expected = 6;
        assertEquals(expected, result);
    }

    @Test
    public void testaCirculo() {
        Cricunferencia c = new Cricunferencia(1);
        c.calcular(2.5);
        double result = 15.707963267948966;
        assertEquals(result, c.getArea());
    }

    @Test
    public void testaCirculoRuim() {
        assertThrows(RuntimeException.class, () -> {
            Cricunferencia c = new Cricunferencia(1);
            c.calcular(-4.9);
        });
    }

    @Test
    public void testaRetangulo() {
        Retangulo r = new Retangulo(2);
        r.calcular(2, 6);
        double result = 12;
        assertEquals(result, r.getArea());
    }

    @Test
    public void testaRetanguloRuim() {
        assertAll(() -> assertThrows(RuntimeException.class, () -> {
            Retangulo r = new Retangulo(2);
            r.calcular(-2, 6);
        }),
        () -> assertThrows(RuntimeException.class, () -> {
            Retangulo r2 = new Retangulo(2);
            r2.calcular(7, -4);
        }));
    }

    @Test
    public void testaTriangulo() {
        Triangulo t = new Triangulo(2);
        t.calcular(2, 6);
        double result = 6;
        assertEquals(result, t.getArea());
    }

    @Test
    public void testaTrianguloRuim() {
        assertAll(() -> assertThrows(RuntimeException.class, () -> {
                Triangulo t = new Triangulo(2);
                t.calcular(-2, 5);
            }),
            () -> assertThrows(RuntimeException.class, () -> {
                Triangulo t = new Triangulo(2);
                t.calcular(7, -4);
            }));
    }
}