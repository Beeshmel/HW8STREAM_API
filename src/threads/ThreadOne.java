package threads;

public class ThreadOne {
    ThreadOne(){
        System.out.println("Сообщение до вызова метода");
        test();
        System.out.println("Мы бы хотели это сообщение увидеть пока метод test выполняется");
    }

    void test(){
        var x = 0;
        while (x < 1000000){
            x++;
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        new ThreadOne();
    }
}
