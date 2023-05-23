package HW1.tasks;

import java.util.Scanner;

public class Task4 {
    /*
     *  Простая (2 балла)
     *  Пользователь задает целое трехзначное число (например, 478).
     *  Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
     */
    public static void start(Scanner in) throws RuntimeException {
        int value;

        try {
            System.out.print("Задание 4:\nВведите целое трехзначное число - ");
            value = in.nextInt();
        } catch (Exception e){
            System.out.println("Некорректный ввод, повторите попытку");
            throw e;
        }

        if (value >= 100 && value < 1000) {
            System.out.printf("Число с перестановкой цифр в обратном порядке - %d\n", numberRevert(value));
        } else {
            System.out.println("Некорректный ввод, повторите попытку");
            throw new RuntimeException();
        }

    }

    private static int numberRevert(int number) {
        return number%10*100 + number%100/10*10 + number/100;
    }
}
