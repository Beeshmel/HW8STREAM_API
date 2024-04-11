package executors;

import java.util.concurrent.Executors;

public class TestExecutor {
    public static void main(String[] args) {
        var executor = Executors.newSingleThreadExecutor();//создали объект для запуска задач Runnable
        executor.execute(()->{//execute принимает только runnable
            for(;;){
                System.out.println(Math.random());
            }
        });
    }
}
