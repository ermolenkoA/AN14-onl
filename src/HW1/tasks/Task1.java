package HW1.tasks;

import java.util.Scanner;

public class Task1 {
    /* Тривиальная (3 балла)
     * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
     * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
     */
    public static void start(Scanner in) throws RuntimeException {
        int hours;
        int minutes;
        int seconds;
        String time;

        System.out.print("Задание 1:\nВведите время в формате hh:mm:ss - ");

        try {
            time = in.next();
            hours = Integer.parseInt(time.substring(0,2));
            minutes = Integer.parseInt(time.substring(3,5));
            seconds = Integer.parseInt(time.substring(6,8));
        } catch (Exception e) {
            System.out.println("Некорректный ввод значений, повторите попытку");
            throw e;
        }

        if (!isTimeFormatCorrect(time) || !isTimeValuesCorrect(hours, minutes, seconds)) {
            System.out.println("Некорректный ввод, повторите попытку");
            throw new RuntimeException();
        } else {
            System.out.printf("Время, прошедшее с начала суток, равно %d секундам\n", seconds(hours, minutes, seconds));
        }
    }

    private static int seconds(int hours, int minutes, int seconds) {
        return (hours * 3600 + minutes*60 + seconds);
    }

    private static boolean isTimeFormatCorrect (String time) {
        return time.length() == 8 && time.charAt(2) == ':' && time.charAt(5) == ':';
    }

    private static boolean isTimeValuesCorrect(int hours, int minutes, int seconds) {
        return (hours > 0 && minutes > 0 && seconds > 0) && hours < 24
                ? minutes < 60 && seconds < 60
                : hours == 24 && minutes == 0 && seconds == 0;

    }
}
