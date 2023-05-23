package HW3.tasks;

import java.util.Scanner;

public class Task4 {
    /*
     * Средняя (3 балла)
     *
     * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
     * Стороны отверстия должны быть параллельны граням кирпича.
     * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
     * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
     * Вернуть true, если кирпич пройдёт
     */
    public static void start(Scanner in) throws RuntimeException {

        System.out.println("Задание 4");
        int a, b, c;

        for (;;) {
            System.out.println("Введите размеры длины сторон кирпича (a, b, c):");
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            if (a > 0 && b > 0 && c > 0)
                break;
            System.out.println("Длины должны быть положительными\n");
        }

        int r, s;

        for (;;) {
            System.out.println("Введите размеры отверстия (r, s):");
            r = in.nextInt();
            s = in.nextInt();
            if (r > 0 && s > 0)
                break;
            System.out.println("Размеры должны быть положительными\n");
        }

        if (brickPasses(a, b, c, r, s))
            System.out.println("Кирпич проходит сквозь отверстие");
        else
            System.out.println("Кирпич не проходит сквозь отверстие");
    }

    private static boolean brickPasses(int a, int b, int c, int r, int s) {
        return (a <= r && b <= s)
                || (b <= r && a <= s)
                || (a <= r && c <= s)
                || (c <= r && a <= s)
                || (b <= r && c <= s)
                || (c <= r && b <= s);
    }
}
