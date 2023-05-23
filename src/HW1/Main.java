package HW1;

import HW1.tasks.Task1;
import HW1.tasks.Task2;
import HW1.tasks.Task3;
import HW1.tasks.Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Task1.start(in);
            Task2.start(in);
            Task3.start(in);
            Task4.start(in);
        } catch (Exception e) {
            in.close();
            return;
        }
        in.close();
    }
}
