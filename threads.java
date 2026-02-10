import java.util.concurrent.*;

public class threads {
    public static void main(String[] args) throws Exception {
        // Single Thread
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.submit(() -> System.out.println("Single Thread Executor running"));
        singleThread.shutdown();

        // Cached Thread Pool
        ExecutorService cachedThread = Executors.newCachedThreadPool();
        for (int i = 1; i <= 3; i++) {
            int id = i;
            cachedThread.submit(() -> System.out.println("Cached Thread Pool Thread " + id + " running"));
        }
        cachedThread.shutdown();

        // ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            System.out.println("Fork-Join Parallelism example");
        }).get();
        forkJoinPool.shutdown();
    }
}
