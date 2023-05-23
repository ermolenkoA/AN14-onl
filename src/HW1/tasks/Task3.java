package HW1.tasks;

import java.util.Scanner;

public class Task3 {
    /*
     *  Простая (2 балла)
     *  Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
     *  Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
     *  Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
     */
    public static void start(Scanner in) throws RuntimeException {
        int initial;
        int percent;

        try {
            System.out.print("Задание 3:\nВведите начальную сумму вклада - ");
            initial = in.nextInt();
            System.out.print("Введите годовую процентную ставку - ");
            percent = in.nextInt();
        } catch (Exception e){
            System.out.println("Некорректный ввод, повторите попытку");
            throw e;
        }

        if (initial >= 0 && percent >= 0) {
            System.out.printf("Итоговая сумма через 3 года - %.2f\n", accountInThreeYears(initial, percent));
        } else {
            System.out.println("Некорректный ввод, повторите попытку");
            throw new RuntimeException();
        }
    }

    private static double accountInThreeYears(int initial, int percent) {
        return initial * Math.pow(1 + (double)percent/100, 3) ;
    }

}
