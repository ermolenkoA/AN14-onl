package HW5;

import HW5.tasks.Task1;
import HW5.tasks.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task1.start(in);
        System.out.println();
        Task2.start(in);
        in.close();
    }
}
