package HW1.tasks;

import java.util.Scanner;

public class Task2 {

    /*
     * Простая (2 балла)
     * Пользователь задает целое число, больше или равно 100 (например, 3801).
     * Определить третью цифру справа в этом числе (в данном случае 8).
     */
    public static void start(Scanner in) throws RuntimeException {
        int value;

        System.out.print("Задание 2:\nВведите целое число, больше или равно 100 - ");
        try {
            value = in.nextInt();
        } catch (Exception e){
            System.out.println("Некорректный ввод, повторите попытку");
            throw e;
        }

        if (value >= 100) {
            System.out.printf("Третья цифра справа - %d\n", thirdDigit(value));
        } else {
            System.out.println("Некорректный ввод, повторите попытку");
            throw new RuntimeException();
        }
    }

    private static int thirdDigit(int number) {
        return number % 1000 / 100;
    }
}
