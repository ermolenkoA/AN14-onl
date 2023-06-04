package HW9.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task2 {
    /*
    Написать класс Phone, создать лист с его элементами.
    Написать функцию, которая на вход будет принимать тип сортировки (по дате, по цене)
    и вывести отсортированные элементы.
    Преобразования над элементами коллекции производить с помощью Stream API
    "13.04.2023"
     */
    public static void start() {
        System.out.println("Задание 2:");
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Xiaomi 13 Ultra", 1000, new GregorianCalendar(2023, Calendar.MAY,13)));
        phones.add(new Phone("Google Pixel 7 pro", 900, new GregorianCalendar(2022, Calendar.OCTOBER,6)));
        phones.add(new Phone("Nokia 3310", 10, new GregorianCalendar(2000, Calendar.SEPTEMBER,5)));
        phones.add(new Phone("iPhone X", 400, new GregorianCalendar(2017, Calendar.NOVEMBER,4)));

        System.out.println("\nСписок:");
        phones.forEach(phone -> System.out.println(phone.toString()));

        System.out.println("\nСписок после сортировки по названию:");
        Phone.sort(phones, (Phone p1, Phone p2) -> {
            return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
        }).forEach(phone -> System.out.println(phone.toString()));

        System.out.println("\nСписок после сортировки по цене:");
        Phone.sort(phones, (Phone p1, Phone p2) -> {
            return Double.compare(p1.getPrice(), p2.getPrice()) * -1;
        }).forEach(phone -> System.out.println(phone.toString()));

        System.out.println("\nСписок после сортировки по дате:");
        Phone.sort(phones, (Phone p1, Phone p2) -> {
            return p1.getReleaseDate().compareTo(p2.getReleaseDate());
        }).forEach(phone -> System.out.println(phone.toString()));
    }
}
