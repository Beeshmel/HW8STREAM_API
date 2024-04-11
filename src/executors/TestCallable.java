package executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


//Отличие call в интерфейсе Callable от run в интерфейсе Runnable
//в том, что run ничего не возращает, а call может сохранять результат

//Для получения результата используем FutureTask

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable callable = new Callable() {
//            @Override
//            public Object call() throws Exception {
//                return null;
//            }
//        };

//        Создали первую задачу
        Callable callable = ()->{
            double sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += Math.random();
            }
            return sum;
        };

        //Создали вторую задачу
        Callable callable2 = ()->{//под капотом запускается call
            double res = 1;
            for (int i = 1; i < 1000; i++) {
                res *= Math.random();
            }
            return res;
        };
//        FutureTask - используем если нужно получить результат после call
        FutureTask<Double> task1 = new FutureTask<>(callable);
        FutureTask<Double> task2 = new FutureTask<>(callable2);

        new Thread(task1).start();//запускаем первую задачу, то есть вызываем call
        new Thread(task2).start();

//        Получаем результат выполнения вышестоящих инструкций

        System.out.println(task1.get());
        System.out.println(task2.get());
    }
}
