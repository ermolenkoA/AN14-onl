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
        ArrayList<Double> list1 = new ArrayList<Double>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int n;
        
        try {
            System.out.print("Введите количество эллементов массива: ");
            n = in.nextInt();
            if (n < 0)
                throw new IllegalArgumentException("Ошибка: количество эллементов массива не может быть меньше 0.");

            System.out.print("Введите массив: ");
            for(int i = 0; i < n; ++i)
                list1.add(in.nextDouble());

            list1.forEach(elem -> list2.add(elem.intValue()));
            centerArrayList(list1);
            centerArrayList(list2);

            System.out.println("Результат Double: " + list1.toString());
            System.out.println("Результат Integer: " + list2.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            in.next();
            System.out.println("Ошибка: Некорректный ввод.");
        }


    }

    public static <T extends Number> void centerArrayList(ArrayList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        double sum = 0;
        for (T elem : list) {
            sum += elem.doubleValue();
        }
        double average = sum / list.size();
        T listElement = list.get(0);
        if (listElement instanceof Float) {
            list.replaceAll(elem -> (T) Float.valueOf((float) (elem.doubleValue() - average)));
        } else if (listElement instanceof Integer) {
            list.replaceAll(elem -> (T) Integer.valueOf((int) (elem.doubleValue() - average)));
        } else if (listElement instanceof Short) {
            list.replaceAll(elem -> (T) Short.valueOf((short) (elem.doubleValue() - average)));
        } else if (listElement instanceof Byte) {
            list.replaceAll(elem -> (T) Byte.valueOf((byte) (elem.doubleValue() - average)));
        } else {
            list.replaceAll(elem -> (T) Double.valueOf(elem.doubleValue() - average));
        }
    }

}
