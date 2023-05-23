package HW4;

import HW4.animals.Food;
import HW4.animals.Crocodile;
import HW4.animals.Cat;

public class Main {
    public static void main(String[] args) {
        Crocodile crocodile1 = new Crocodile("Гена", 100, 2);
        Crocodile crocodile2 = new Crocodile("Гена", 110.2, 2);
        Cat cat = new Cat("Василий", 8, "Британский");

        System.out.println("\n" + crocodile1.toString());
        System.out.println("\n" + crocodile2.toString());
        System.out.println("\n" + cat.toString());

        System.out.println(crocodile1.equals(crocodile2) ? "\nКрокодилы равны" : "\nКрокодилы не равны");

        System.out.println("\ncrocodile1.feed(Food.Milk)");
        crocodile1.feed(Food.Milk);
        System.out.println("\ncat.feed(Food.Milk)");
        cat.feed(Food.Milk);

        System.out.println("\ncrocodile1.makeASound()");
        crocodile1.makeASound();
        System.out.println("\ncat.makeASound()");
        cat.makeASound();

        System.out.println("\ncat.goToOwner()");
        cat.goToOwner();
    }
}
