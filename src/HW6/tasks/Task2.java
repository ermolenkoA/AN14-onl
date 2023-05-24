package HW6.tasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    /*
     * Сложная (6 баллов)
     *
     * В строке представлено выражение вида "2 + 31 - 40 + 13",
     * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
     * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
     * Вернуть значение выражения (6 для примера).
     * Про нарушении формата входной строки бросить исключение IllegalArgumentException
     */
    public static void start(Scanner in) {
        System.out.println("Задание 2:\nВведите выражение:");
        String expression = in.nextLine();
        try {
            System.out.printf("Результат выражения - %d", getExpressionResult(expression));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int getExpressionResult(String input) throws IllegalArgumentException{

        if(!input.matches("([+-] )?\\d+( [+-] \\d+)*")){
            throw new IllegalArgumentException("Ошибка: введенные не подходят по формату.");
        }

        Pattern pattern = Pattern.compile("([+-] )?(\\d+)");
        Matcher matcher = pattern.matcher(input);

        matcher.find();
        String sign = matcher.group(1);
        int result = Integer.parseInt(matcher.group(2));

        if (sign != null && sign.contains("-")) {
            result *= -1;
        }
        matcher.usePattern(Pattern.compile(" ([+-]) (\\d+)"));

        while (matcher.find()) {
            sign = matcher.group(1);
            int next = Integer.parseInt(matcher.group(2));

            result = result + (sign.equals("-") ? -next : next);
        }

        return result;
    }
}
