package model;

public class Triangulo {
    public Triangulo(double b, double h) {
        if(b > 0 && h > 0) {
            this.setArea((b *h) / 2);
        } else {
            throw new RuntimeException("Impossível calcular área com valor negativo.");
        }
    }

    double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
