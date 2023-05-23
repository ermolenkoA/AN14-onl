package HW5.tasks;

import java.util.Scanner;

public class Task1 {
    /*
     *  Найти в массиве самую длинную последовательность,
     *  состоящую из одинаковых элементов. Вывести на экран
     *  количество элементов самой длиной последовательности
     *  и номер элемента, который является ее началом.
     */
    public static void start(Scanner in) throws RuntimeException {
        int n;
        while (true) {
            System.out.print("Задание 1:\nВведите количество эллементов массива: ");
            n = in.nextInt();
            if (n > 0)
                break;
            System.out.println("Ошибка: Некорректный ввод. Повоторите попытку.");
        }

        int[] array = new int[n];

        System.out.print("Введите массив: ");
        for(int i = 0; i < n; ++i) {
            array[i] = in.nextInt();
        }

        int firstIndexMax = 0;
        int lengthMax = 0;
        int firstIndex = 0;
        int length = 0;

        for(int i = 0; i < n; ++i) {
            if (array[firstIndex] == array[i]) {
                length++;
                continue;
            }
            if (lengthMax < length) {
                lengthMax = length;
                firstIndexMax = firstIndex;
            }
            length = 0;
            firstIndex = i + 1;
        }

        if (lengthMax < length) {
            lengthMax = length;
            firstIndexMax = firstIndex;
        }

        System.out.printf("Первый индекс эллемента %d, максимальная длинна последовательности %d", firstIndexMax, lengthMax);
    }

}
