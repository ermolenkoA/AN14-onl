package HW2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array;
        try {
            array = getArrayOfInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        swapMaxAndMin(array);
        printArrayOfInt(array);
    }

    private static int[] getArrayOfInt() throws Exception{

        Scanner in = new Scanner(System.in);
        int arraySize;
        System.out.print("Введите количество эллементов массива: ");

        try {
            arraySize = in.nextInt();
        } catch (Exception e) {
            in.close();
            throw new Exception("Ошибка: Некорректный ввод");
        }
        if (arraySize < 0) {
            in.close();
            throw new Exception("Ошибка: Количество эллементов массива не может быть отрицательным");
        } else if(arraySize == 0 ) {
            return new int[0];
        }

        int[] resultArray = new int[arraySize];
        System.out.print("Введите массив целых чисел: ");
        try {
            for(int i = 0; i < arraySize; i++) {
                resultArray[i] = in.nextInt();
            }
        } catch (Exception e) {
            in.close();
            throw new Exception("Ошибка: Некорректный ввод");
        }

        in.close();
        return resultArray;
    }

    private static void swapMaxAndMin(int[] array) {
        int maxIndex = 0;
        int minIndex = 0;

        for(int i = 1; i < array.length; i++) {
            if (array[maxIndex] < array[i]){
                maxIndex = i;
            }
            if(array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        if(maxIndex != minIndex) {
            int temp = array[maxIndex];
            array[maxIndex] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    private static void printArrayOfInt(int[] array) {
        System.out.print("Результат:");
        for(int element: array) {
            System.out.printf(" %d", element);
        }
        System.out.print("\n");
    }
}
