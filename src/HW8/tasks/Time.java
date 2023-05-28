package HW8.tasks;

import java.util.Random;
import java.util.List;

public class Time {
    public static long measureAdd(List<Pair<Integer, String>> list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            Pair<Integer, String> pair = new Pair<>(i, "Value" + i);
            list.add(pair);
        }

        return System.currentTimeMillis() - startTime;
    }

    public static long measureGetRandom(List<Pair<Integer, String>> list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int randomIndex = random.nextInt(list.size());
            Pair<Integer, String> pair = list.get(randomIndex);
        }

        return System.currentTimeMillis() - startTime;
    }
}
