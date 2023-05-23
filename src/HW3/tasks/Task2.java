package HW3.tasks;

import java.util.Scanner;

public class Task2 {
    /*
     * Средняя (3 балла)
     *
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     */
    public static void start(Scanner in) {
        System.out.println("Задание 2");
        int a, b, c, d;
        for (;;){
            System.out.println("Введите координаты точек a, b, c, d (b >= a, d >= c):");
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            if (b >= a || d >= c)
                break;
            System.out.println("Входные данные не соответствуют условию b >= a, d >= c.\n");
        }

        int result = segmentLength(a, b, c, d);
        if (result == -1) {
            System.out.println("Отрезки AB и CD не пересекаются.");
        } else {
            System.out.printf("Длина пересечения отрезков AB и CD равна %d.", result);
        }
    }

    private static int segmentLength(int a, int b, int c, int d) {
        if (Math.max(a, c) <= Math.min(b, d))
            return Math.min(b, d) - Math.max(a, c);
        return -1;
    }
}
