package main;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Scanner;

/**
 * Tarefa 1: Construa uma classe com três métodos estáticos...
 */
public class CalculaArea {
    public static void main(String[] args) {

        CalculaArea c = new CalculaArea();
        Scanner scanner = new Scanner(System.in);

        double a = 0;
        double b = 0;
        System.out.println("Digite o tipo de área a ser calculado: \n 1 = Retangulo \n 2 = Triangulo \n 3 = Circulo");
        int op = scanner.nextInt();
        System.out.println("Digite o tamanho do primeiro lado, base, ou raio:");
        a = scanner.nextDouble();
        if (op != 3) {
            System.out.println("Digite o tamanho do segundo lado, altura, ou zero:");
            b = scanner.nextDouble();
        }
        c.calcula(a, b, op);
        /*c.calcula(4.0, 6.0, 1);
        c.calcula(3.0,3.0, 2);
        c.calcula(2, 0, 3);
        c.calcula(1, 1, 5);*/
    }

    public double calcula(double a, double b, int op) {
        switch (op) {
            case 1:
                return calculaRetangulo(a, b);
            case 2:
                return calculaTriangulo(a, b);
            case 3:
                return calculaCirculo(a);
            default:
                System.out.println("Operação não idenficada. \n Operações disponíveis são: \n 1 = Retangulo (lado a & lado b) \n 2 = Triangulo (base & altura) \n 3 = Circulo (raio)");
                return 404;
        }
    }

    public double calculaRetangulo(double a, double b) {
        if (0 > a || 0 > b) {
            throw new RuntimeException("Valor negativo identificado");
        } else if (a == 0 || b == 0) {
            throw new RuntimeException("Zero identificado");
        } else {
            double result =  (a * b);
            System.out.println("Area = " + result);
            return (result);
        }
    }

    private double calculaTriangulo(double base, double altura) {
        if (0 > base || 0 > altura) {
            throw new RuntimeException("Valor negativo identificado");
        } else if (base == 0 || altura == 0) {
            throw new RuntimeException("Zero identificado");
        } else {
            double result =  (base * altura) / 2;
            System.out.println("Area = " + result);
            return (result);
        }
    }

    private double calculaCirculo(double a) {
        if (0 > a) {
            throw new RuntimeException("Valor negativo identificado");
        } else if (a == 0) {
            throw new RuntimeException("Zero identificado");
        } else {
            double result =  Math.PI * Math.pow(a, 2.5);
            System.out.println("Area = " + result);
            return (result);
        }
    }
}
