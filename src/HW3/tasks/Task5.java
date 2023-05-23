package HW3.tasks;

import java.util.Scanner;

public class Task5 {
    /*
     * Сложная (4 балла)
     *
     * Найти n-ю цифру последовательности из квадратов целых чисел:
     * 149162536496481100121144...
     * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */

    public static void start(Scanner in) throws RuntimeException {
        System.out.println("Задание 5");
        int n;
        for (;;) {
            System.out.println("Введите номер цифры для поиска в последовательности из квадратов целых чисел:");
            n = in.nextInt();
            if (n > 0)
                break;
            System.out.println("Номер должн быть положительным\n");
        }

        System.out.printf("Цифра под номером %d равна %d", n, squareSequenceDigit(n));
    }

    private static int squareSequenceDigit(int n) {
        int index = 0;
        int digit;
        int number = 0;
        int numberSquare;
        for(;;)
        {
            ++number;
            numberSquare = number*number;
            int numberSquareReversed = 0;
            while (numberSquare != 0) {
                numberSquareReversed *= 10;
                numberSquareReversed += numberSquare % 10;
                numberSquare /= 10;
            }
            while (numberSquareReversed != 0)
            {
                digit = numberSquareReversed % 10;
                numberSquareReversed /= 10;
                index++;
                if(index == n) {
                    return digit;
                }
            }
        }
    }
}