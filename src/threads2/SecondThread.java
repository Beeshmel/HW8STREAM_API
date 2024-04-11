package threads2;

//Для возможности работать одновременно с основным потоком нужно использовать один из нескольких
//способов: наследование от Thread, реализация интерфейса Runnable, использовать executors

//Чтобы действия выполнялись в отдельном потоке нужно переопределять метод run, то есть то,
//что будет в методе run выполняется в отдельном потоке, то есть одновременно с другими потоками.
//Для запуска метода run используйте метод start

public class SecondThread {
    private String titleThread;
    SecondThread(String titleThread){
        this.titleThread = titleThread;
        var obj = new Thread(){
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
        };
        obj.start();

    }



    public static void main(String[] args) {
        var obj = new SecondThread("Первый поток");
        var obj2 = new SecondThread("Второй поток");

    }
}
