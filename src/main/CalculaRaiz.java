package main;

public class CalculaRaiz {
    public static void main(String[] args) {
        CalculaRaiz raiz = new CalculaRaiz();

        raiz.calcula(1, -5, 6);
    }

    public double[] calcula(double a, double b, double c) {
        double delta = (Math.pow(b,2) + ((-4*a)*c));
        System.out.println(delta);
        if (0 > delta) {
            throw new RuntimeException("Valores com raiz imaginária.");
        }
        if (delta == 0) {
            System.out.println("Raízes serão iguais se simplificadas.");
        }
        double x1 = (-b + Math.sqrt(delta)) / 2*a;
        double x2 = (-b - Math.sqrt(delta)) / 2*a;

        double[] result = {x1, x2};
        System.out.println("Resultado: x1 = " + result[0] + ", x2 = " + result[1]);
        return result;
    }
}
