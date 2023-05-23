package HW4.animals;

import java.util.Objects;

public class Crocodile extends Animal {
    double length;

    public Crocodile(String name, double weight, int length) {
        super(name, weight);
        setLength(length);
    }

    public Crocodile() {
        this("Unknown", 0, 0);
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0)
            this.length = length;
    }

    @Override
    public void makeASound() {
        System.out.println("*Sounds of hell*");
    }

    @Override
    public void feed(Food food) {
        if (food != Food.Meat && food != Food.Fish) {
            System.out.println("Error: looks like you'll be his lunch");
        } else {
            System.out.println("*The sounds of eating*");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Crocodile crocodile = (Crocodile) o;
        return length == crocodile.length
                && getName() == crocodile.getName()
                && getWeight() == crocodile.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, getName(), getWeight());
    }

    @Override
    public String toString() {
        return this.getClass().getName()
                + " {"
                + "\nName: " + getName()
                + "\nWeight: " + getWeight()
                + "\nLength: " + length
                + "\n} ";
    }
}
