package top.kenetgit.springbootdemo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/task")
public class TestAsyncTask {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/doTask1")
    public String test1() throws InterruptedException {

        long s = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while(!a.isDone() || !b.isDone() || !c.isDone()) {
            if(a.isDone() && b.isDone() && c.isDone())
                break;
        }

        long e = System.currentTimeMillis();

        String res = "task finished with time: " + (e-s) + "ms";
        return res;
    }
}
