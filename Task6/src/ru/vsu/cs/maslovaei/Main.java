package ru.vsu.cs.maslovaei;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNum("Input x: ");
        double n = readNum("Input n: ");
        double e = readNum("Input e: ");

        printResults(n, e, x);
    }

    private static double readNum(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextDouble();
    }

    private static double returnModule(double x) {
        return x > 0 ? x : -x;
    }

    private static double raiseNumber(double number, double degree) {
        double result = 1;
        for (int i = 1; i <= degree; i++) {
            result *= number;
        }
        return result;
    }

    private static double calculateMember(double x, double n) {
        return raiseNumber(-1, (n - 1)) * raiseNumber(x, (n - 1));
    }

    private static double calculateFirstSum(double n, double x) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += calculateMember(x, i);
        }
        return sum;
    }

    private static double calculateSecondSum(double x, double n, double e) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            double member = calculateMember(x, i);
            if (returnModule(member) > e) {
                sum += calculateMember(x, i);
            }
        }
        return sum;
    }

    private static double calculateThirdSum(double x, double n, double e) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            double member = calculateMember(x, i);
            if (returnModule(member) > e / 10) {
                sum += calculateMember(x, i);
            }
        }
        return sum;
    }

    private static double calculateFunction(double x) {
        return 1 / (1 + x);
    }

    private static void printResults(double n, double e, double x) {
        System.out.printf("Sum of %s elements: %.2f", n, calculateFirstSum(n, x));
        System.out.println();
        System.out.printf("Sum of elements that are greater in absolute value than %s: %.2f", e, calculateSecondSum(x, n, e));
        System.out.println();
        System.out.printf("Sum of elements that are greater in absolute value than %s: %.2f", e / 10, calculateThirdSum(x, n, e));
        System.out.println();
        System.out.printf("Value of function: %.2f", calculateFunction(x));
    }
}
