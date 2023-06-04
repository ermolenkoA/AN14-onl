package HW9.tasks;

import java.util.Optional;

public class Task1 {
    /*
    Повторить пример с Optional по теме компьютера
    (пример тут: https://www.oracle.com/technical-resources/articles/java/java8-optional.html)
     */
    public static void start() {
        System.out.println("Задание 1:");

        Optional<USB> usb = Optional.of(new USB("3.0"));
        Optional<Soundcard> soundcard = Optional.of(new Soundcard(usb));
        Optional<Computer> computer = Optional.of(new Computer(soundcard));

        String name = computer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        System.out.println("Версия USB звуковой карты - " + name);
    }
}
