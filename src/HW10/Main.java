package HW10;

public class Main {
    public static void main(String[] args) {

        for(int i=1;i<6;i++)
            new Philosopher(i).start();
    }
}

class Philosopher extends Thread {
    int num = 0;
    Philosopher(int id) {
        this.setName(Integer.toString(id));
    }

    public void run() {
        try {
            while (num < 3)
            {
                sitDown(this);
                num++;
                sleep(500);

            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + getName() + " проблемы со здоровьем");
        }
    }
    synchronized public static void sitDown(Philosopher philosopher) throws InterruptedException{
        System.out.println("Философ " + philosopher.getName() + " садится за стол");
        sleep(500);
        System.out.println("Философ " + philosopher.getName() + " выходит из-за стола");
    }

}