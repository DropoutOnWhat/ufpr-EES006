package main;

import model.Cricunferencia;
import model.Retangulo;
import model.Triangulo;
import org.junit.platform.commons.util.StringUtils;

import java.util.Scanner;

public class UsaFormas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int i = 0;
        double a = 0;
        double b = 0;
        String f = null;
        StringBuilder result = new StringBuilder();
        System.out.print("Informe quantas areas deseja calcular: ");
        max = scanner.nextInt();
        while(max > i) {
            System.out.println("Informe C, R ou T para o tipo de formula que deseja calcular. Informe X para sair.");
            f = scanner.next();
            if(!"X".equalsIgnoreCase(f)) {
                f = f.toLowerCase();
                switch (f) {
                    case "c":
                        try {
                            System.out.print("Informe o raio: ");
                            a = scanner.nextDouble();
                            Cricunferencia c = new Cricunferencia(a);
                            result.append("Calculo " + i + ": ")
                                    .append("Area do circulo com raio = ")
                                    .append(a)
                                    .append(" é: ")
                                    .append(c.getArea())
                                    .append("\n");
                        } catch (RuntimeException re) {
                            System.out.println(re.getMessage());
                        } finally {
                            i++;
                            continue;
                        }
                    case "r":
                        try {
                            System.out.print("Informe o lado A: ");
                            a = scanner.nextDouble();
                            System.out.print("Informe o lado B: ");
                            b = scanner.nextDouble();
                            Retangulo r = new Retangulo(a, b);
                            result.append("Calculo " + i + ": ")
                                    .append("Area do retangulo com lados ")
                                    .append(a)
                                    .append(" e ")
                                    .append(b)
                                    .append(" é: ")
                                    .append(r.getArea())
                                    .append("\n");
                        } catch (RuntimeException re) {
                            System.out.println(re.getMessage());
                        } finally {
                            i++;
                            continue;
                        }
                    case "t":
                        try {
                            System.out.print("Informe a base: ");
                            a = scanner.nextDouble();
                            System.out.print("Informe a altura: ");
                            b = scanner.nextDouble();
                            Triangulo t = new Triangulo(a, b);
                            result.append("Calculo " + i + ": ")
                                    .append("Area do triangulo com base = ")
                                    .append(a)
                                    .append(" e altura = ")
                                    .append(b)
                                    .append(" é: ")
                                    .append(t.getArea())
                                    .append("\n");
                        } catch (RuntimeException re) {
                            System.out.println(re.getMessage());
                        } finally {
                            i++;
                            continue;
                        }
                    default:
                        System.out.println("Forma desconhecida.");
                        continue;
                }
            } else {
                result.append("Leitura finalizada pelo usuário.");
                break;
            }
        }
        if(i > 0) {
            System.out.println("Todas as areas informadas foram calculadas:");
            if(StringUtils.isBlank(result.toString())) {
                System.out.println("Todos os calculos falharam");
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("Encerrou sem dados para calculo.");
        }
    }
}
