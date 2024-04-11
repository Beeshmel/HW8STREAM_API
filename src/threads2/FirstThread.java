package threads2;

//Для возможности работать одновременно с основным потоком нужно использовать один из нескольких
//способов: наследование от Thread, реализация интерфейса Runnable, использовать executors

//Чтобы действия выполнялись в отдельном потоке нужно переопределять метод run, то есть то,
//что будет в методе run выполняется в отдельном потоке, то есть одновременно с другими потоками.
//Для запуска метода run используйте метод start

public class FirstThread extends Thread{
    private String titleThread;
    FirstThread(String titleThread){
        this.titleThread = titleThread;
    }

    @Override
    public void run() {
        var i = 0;
        while (i < 10){
            i++;
            System.out.println("Поток " + titleThread + ", i = " + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new FirstThread("Первый поток");
        obj.start();
        var obj2 = new FirstThread("Второй поток");
        obj2.start();
    }
}
