package HW3.tasks;

import java.util.Scanner;

public class Task1 {
    /*
     * Простая (2 балла)
     *
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    public static void start(Scanner in) throws RuntimeException {
        System.out.println("Задание 1\nВведите длины сторон треугольника: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        int result = triangleKind(a, b, c);
        switch (result) {
            case -1 -> System.out.println("Треугольник не существует");
            case 0 -> System.out.println("Треугольник является остроугольным");
            case 1 -> System.out.println("Треугольник является прямоугольным");
            default -> System.out.println("Треугольник является тупоугольным");
        }
    }

    private static int triangleKind(double a, double b, double c) {
        if (a + b < c || a + c < b || b + c < a)
            return -1;
        double cosA = b * b + c * c - a * a;
        double cosB = c * c + a * a - b * b;
        double cosC = a * a + b * b - c * c;
        if (cosA < 0 || cosB < 0 || cosC < 0)
            return 2;
        else if (cosA == 0 || cosB == 0 || cosC == 0)
            return 1;
        else
            return 0;
    }

}
