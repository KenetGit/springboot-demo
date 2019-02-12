package top.kenetgit.springbootdemo.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000 )
//    @Scheduled(cron = "")
    public void reportCurrentTime() {
        System.out.println("now: "+ dateFormat.format(new Date()));

    }
}
