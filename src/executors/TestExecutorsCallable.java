package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class TestExecutorsCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var future = executor.submit(()->{
            double sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += Math.random();
            }
            return sum;
        });
        System.out.println(future.get());
        executor.shutdown();//данный метод завершает выполнение всех задач
    }
}
