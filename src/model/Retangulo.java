package model;

public class Retangulo extends Forma {

    double area;

    public Retangulo(int numMedidas) {
        super(numMedidas);
    }

    public void calcular(double a, double b) {
        if(a > 0 && b > 0) {
            this.setArea(a * b);
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
