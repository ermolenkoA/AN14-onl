package HW3.tasks;

import java.util.Scanner;

public class Task6 {
    /*
     * Сложная (5 баллов)
     *
     * Найти n-ю цифру последовательности из чисел Фибоначчи:
     * 1123581321345589144...
     * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static void start(Scanner in) throws RuntimeException {
        System.out.println("Задание 6");
        int n;
        for (;;) {
            System.out.println("Введите номер цифры для поиска в последовательности из чисел Фибоначчи:");
            n = in.nextInt();
            if (n > 0)
                break;
            System.out.println("Номер должн быть положительным\n");
        }

        System.out.printf("Цифра под номером %d равна %d", n, fibSequenceDigit(n));
    }

    public static int fibSequenceDigit(int n) {
        if(n <= 2){
            return 1;
        }

        int firstNum = 1;
        int secondNum = 1;
        int lastNum;
        int digit;

        for(int i = 2; ;){
            lastNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = lastNum;

            int lastNumReversed = 0;
            while (lastNum != 0) {
                lastNumReversed *= 10;
                lastNumReversed += lastNum % 10;
                lastNum /= 10;
            }

            while (lastNumReversed != 0)
            {
                digit = lastNumReversed % 10;
                lastNumReversed /= 10;
                i++;
                if(i == n) {
                    return digit;
                }
            }
        }
    }
}
