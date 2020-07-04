package model;

public class Cricunferencia {

    public Cricunferencia(double raio) {
        if(raio > 0) {
            double result = 2 * Math.PI * raio;
            this.setArea(result);
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
