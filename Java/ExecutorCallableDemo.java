import java.util.concurrent.*;

public class ExecutorCallableDemo {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> "Result from Task 1";
        Callable<String> task2 = () -> "Result from Task 2";
        Callable<String> task3 = () -> "Result from Task 3";

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        Future<String> future3 = executor.submit(task3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        executor.shutdown();
    }
}