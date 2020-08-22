package model;

public class Cricunferencia extends Forma {

    double area;

    public Cricunferencia(int numMedidas) {
        super(numMedidas);
    }

    public void calcular(double raio) {
        if(raio > 0) {
            double result = 2 * Math.PI * raio;
            this.setArea(result);
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
        double raio = super.getMedida(1);
        this.calcular(raio);
        return this.getArea();
    }
}
