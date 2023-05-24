package HW6.tasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    /*
    * Сложная (6 баллов)
    *
    * Строка содержит названия товаров и цены на них в формате вида
    * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
    * То есть, название товара отделено от цены пробелом,
    * а цена отделена от названия следующего товара точкой с запятой и пробелом.
    * Вернуть название самого дорогого товара в списке (в примере это Курица),
    * или пустую строку при нарушении формата строки.
    * Все цены должны быть больше нуля либо равны нулю.
    * В случае неверной строки выкинуть свое исключение.
    */
    public static void start(Scanner in) {
        System.out.println("Задание 1:\nВведите товары и цены: ");
        String input = in.nextLine();
        try {
            String theMostExpensiveItem = getTheMostExpensiveItem(input);
            if (theMostExpensiveItem.isEmpty()) {
                System.out.println("Некоректный ввод данных");
            } else {
                System.out.println("Самый дорогой товар - " + theMostExpensiveItem);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getTheMostExpensiveItem(String input) throws IllegalArgumentException{
        String theMostExpensiveItem = "";
        double maxPrice = -1;

        if(!input.matches("(\\S+ \\d*\\.?\\d+; )*(\\S+ \\d*\\.?\\d+)")){
            throw new IllegalArgumentException("Ошибка: строка не подходит по формату.");
        }

        Pattern pattern = Pattern.compile("(\\S+) (\\d*\\.?\\d+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String itemName = matcher.group(1);
            double itemPrice = Double.parseDouble(matcher.group(2));

            if (itemPrice > maxPrice) {
                maxPrice = itemPrice;
                theMostExpensiveItem = itemName;
            }
        }

        return theMostExpensiveItem;
    }

}
