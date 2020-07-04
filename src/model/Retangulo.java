package model;

public class Retangulo {
    public Retangulo(double a, double b) {
        if(a > 0 && b > 0) {
            this.setArea(a * b);
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
