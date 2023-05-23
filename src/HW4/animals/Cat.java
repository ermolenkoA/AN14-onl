package HW4.animals;

import java.util.Objects;

public class Cat extends Animal implements Domesticated {

    private String breed;

    public Cat(String name, double weight, String breed) {
        super(name, weight);
        this.breed = breed;
    }

    public Cat() {
        this("Unknown", 0, "Unknown");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeASound() {
        System.out.println("Meow");
    }

    @Override
    public void feed(Food food) {
        if (food != Food.Meat && food != Food.Milk && food != Food.Fish) {
            System.out.println("Error: the cat doesn't eat such food");
        } else {
            System.out.println("*Sounds of happiness*");
        }
    }

    @Override
    public void goToOwner() {
        System.out.println("I'm already running");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cat cat = (Cat) o;
        return breed == cat.breed && getName() == cat.getName() && getWeight() == cat.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, getName(), getWeight());
    }

    @Override
    public String toString() {
        return this.getClass().getName()
                + " {"
                + "\nName: " + getName()
                + "\nWeight: " + getWeight()
                + "\nBread: " + getBreed()
                + "\n} ";
    }

}
