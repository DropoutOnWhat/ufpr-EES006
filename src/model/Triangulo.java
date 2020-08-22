package model;

public class Triangulo extends Forma {
    double area;

    public Triangulo(int numMedidas) {
        super(numMedidas);
    }

    public void calcular(double b, double h) {
        if(b > 0 && h > 0) {
            this.setArea((b *h) / 2);
        } else {
            throw new RuntimeException("Impossível calcular área com valor negativo.");
        }
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double area() {
        double a = super.getMedida(1);
        double b = super.getMedida(2);
        this.calcular(a, b);
        return this.getArea();
    }
}
