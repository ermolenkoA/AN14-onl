package HW8;

import HW8.tasks.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import HW8.tasks.Time;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pair<Integer, String>> arrayList = new ArrayList<>();
        LinkedList<Pair<Integer, String>> linkedList = new LinkedList<>();

        long arrayListAddTime = Time.measureAdd(arrayList);
        System.out.println("ArrayList добавление элементов: " + arrayListAddTime + " мс");

        long linkedListAddTime = Time.measureAdd(linkedList);
        System.out.println("LinkedList добавление элементов: " + linkedListAddTime + " мс");

        long arrayListGetRandomTime = Time.measureGetRandom(arrayList);
        System.out.println("ArrayList выбор элементов наугад: " + arrayListGetRandomTime + " мс");

        long linkedListGetRandomTime = Time.measureGetRandom(linkedList);
        System.out.println("LinkedList выбор элементов наугад: " + linkedListGetRandomTime + " мс");
    }
}
