package top.kenetgit.springbootdemo.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doTask11() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task1 consumes time: " + (end - start) + "ms");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask22() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("task2 consumes time: " + (end - start) + "ms");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask33() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(300);
        long end = System.currentTimeMillis();
        System.out.println("task3 consumes time: " + (end - start) + "ms");
        return new AsyncResult<>(true);
    }
}
