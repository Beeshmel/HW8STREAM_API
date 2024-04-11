package threads3;

public class TestThread extends Thread {
    TestThread(String title){
        setName(title);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName() + " finished");
    }

    public static void main(String[] args) {
        new TestThread("Поток №1").start();
        new TestThread("Поток №2").start();
        new TestThread("Поток №3").start();
    }
}