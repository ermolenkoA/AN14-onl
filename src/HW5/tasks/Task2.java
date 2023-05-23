package HW5.tasks;

import java.util.Scanner;

public class Task2 {
    /*
     * Сложная (5 баллов)
     *
     * Перевести натуральное число n > 0 в римскую систему.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: 23 = XXIII, 44 = XLIV, 100 = C
     */
    public static void start(Scanner in) {
        System.out.print("Задание 2:\nВведите число: ");
        int number = in.nextInt();
        String romanNumeral = convertToRoman(number);
        System.out.println(number + " в римской системе: " + romanNumeral);
    }

    public static String convertToRoman(int number) {

        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String romanNumeral = "";

        int i = 0;
        while (number > 0) {
            if (number >= arabicValues[i]) {
                romanNumeral += romanSymbols[i];
                number -= arabicValues[i];
            } else {
                i++;
            }
        }

        return romanNumeral;
    }
}
