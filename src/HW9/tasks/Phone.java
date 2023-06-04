package HW9.tasks;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Phone {
    private String name;
    private double price;
    private Calendar releaseDate;

    Phone(String name, double price, Calendar releaseDate) {
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public static ArrayList<Phone> sort(ArrayList<Phone> phones, Comparator<Phone> comparator) {
        return  phones.stream()
                .sorted(comparator).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        int year = releaseDate.get(Calendar.YEAR);
        int month = releaseDate.get(Calendar.MONTH) + 1;
        int day = releaseDate.get(Calendar.DAY_OF_MONTH) + 1;
        return String.format("%s - %.2f$ - %d.%d.%d", name, price, day, month, year);
    }
}
