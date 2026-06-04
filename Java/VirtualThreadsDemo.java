public class VirtualThreadsDemo {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[100000];

        for (int i = 0; i < 100000; i++) {
            int taskId = i;

            threads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread " + taskId);
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time Taken: " + (end - start) + " ms");
    }
}