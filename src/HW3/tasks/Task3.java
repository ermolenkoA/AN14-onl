package HW3.tasks;

import java.util.Scanner;

public class Task3 {
    /*
     * Простая (2 балла)
     *
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     * Вернуть true, если утверждение верно
     */
    public static void start(Scanner in) throws RuntimeException {
        System.out.println("Задание 3");
        double x1, y1, r1, x2, y2, r2;

        for (;;) {
            System.out.println("Введите данные первой окружности x1, y1, r1:");
            x1 = in.nextDouble();
            y1 = in.nextDouble();
            r1 = in.nextDouble();
            if (r1 > 0)
                break;
            System.out.println("Радиус должен быть положительным\n");
        }

        for (;;) {
            System.out.println("Введите данные второй окружности x2, y2, r2:");
            x2 = in.nextDouble();
            y2 = in.nextDouble();
            r2 = in.nextDouble();
            if (r2 > 0)
                break;
            System.out.println("Радиус должен быть положительным\n");
        }

        if (circleInside(x1, y1, r1, x2, y2, r2))
            System.out.println("Первая окружность целиком лежит внутри второй");
        else
            System.out.println("Первая окружность не лежит внутри второй");
    }

    private static boolean circleInside(double x1, double y1, double r1, double x2, double y2, double r2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) + r1 <= r2;
    }

}
