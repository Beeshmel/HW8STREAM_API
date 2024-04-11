package executors;

public class LambdaRunnable {
    public static void main(String[] args) {
//        Runnable task1 = new Runnable() {
//            @Override
//            public void run(int x) {
//                System.out.println("Выполняем задачу №1");
//            }
//        };

        Runnable task1 = ()-> {//в фигурных скобках переопределяем run, потому что кроме run в Runnable ничего нет
            System.out.println("Выполняем задачу №1");
        };
        Runnable task2 = ()-> {//в фигурных скобках переопределяем run, потому что кроме run в Runnable ничего нет
            System.out.println("Выполняем задачу №2");
        };
        Runnable task3 = ()-> {//в фигурных скобках переопределяем run, потому что кроме run в Runnable ничего нет
            System.out.println("Выполняем задачу №3");
        };
        Runnable task4 = ()-> {//в фигурных скобках переопределяем run, потому что кроме run в Runnable ничего нет
            System.out.println("Выполняем задачу №4");
        };
        Runnable task5 = ()-> {//в фигурных скобках переопределяем run, потому что кроме run в Runnable ничего нет
            System.out.println("Выполняем задачу №5");
        };

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task4).start();
        new Thread(task5).start();


    }
}
