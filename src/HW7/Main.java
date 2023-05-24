package HW7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*
     * Средняя (3 балла)
     *
     * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
     * Если список пуст, не делать ничего. Вернуть изменённый список.
     *
     * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<Double>();

        while (true) {
            System.out.print("Введите количество эллементов массива: ");
            try {
                int n = in.nextInt();
                if (n <= 0)
                    throw new IllegalArgumentException("Ошибка: количество эллементов массива должно быть больше 0.\n");


                while (true){
                    try {
                        System.out.print("Введите массив: ");
                        list.clear();
                        for(int i = 0; i < n; ++i)
                            list.add(in.nextDouble());
                       break;
                    } catch (InputMismatchException ex) {
                        in.next();
                        System.out.println("Ошибка: Некорректный ввод.\n");
                    }
                }

                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (InputMismatchException ex) {
                in.next();
                System.out.println("Ошибка: Некорректный ввод.\n");
            }
        }
        centerArray(list);
        System.out.println("Результат: " + list.toString());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> void centerArray(ArrayList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        double sum = 0;
        for (T elem : list) {
            sum += elem.doubleValue();
        }
        double average = sum / list.size();

        list.replaceAll(elem -> (T) Double.valueOf(elem.doubleValue() - average));
    }

}
