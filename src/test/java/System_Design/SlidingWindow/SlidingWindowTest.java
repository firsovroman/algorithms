package System_Design.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SlidingWindowTest {

    @Test
    public void testGrantAccess() throws InterruptedException {

        SlidingWindow slidingWindow = new SlidingWindow(60,5);

        for (int i = 0; i < 5; i++) {
            System.out.println(slidingWindow.grantAccess() + " - " + Instant.now());
            Thread.sleep(15_000);
        }

        Thread.sleep(5_000);
        System.out.println("=============");

//        for (int i = 0; i < 5; i++) {
//            System.out.println(slidingWindow.grantAccess() + " - " + Instant.now());
//        }


        // за 20 секунд окно успевает сместится и освободить 2 токена из 5
        Assert.assertTrue(slidingWindow.grantAccess());
        Assert.assertTrue(slidingWindow.grantAccess());

        Assert.assertFalse(slidingWindow.grantAccess());

    }



    @Test
    public void concurrencyTestGrantAccess() throws InterruptedException {

        SlidingWindow slidingWindow = new SlidingWindow(1,5);
        SlidingWindowWrapper wrapper = new SlidingWindowWrapper(slidingWindow);

        ExecutorService executors = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            executors.execute(wrapper::tryAcquire);
        }
        executors.shutdown();

    }
}