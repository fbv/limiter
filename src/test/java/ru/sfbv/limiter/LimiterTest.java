package ru.sfbv.limiter;

import org.junit.Test;

/**
 * @author Boris Fedorov
 */
public class LimiterTest {

    @Test
    public void testLimit() {
        Limiter limiter = new Limiter(3, 1000);
        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            limiter.limit();
            System.out.println("waited " + (System.currentTimeMillis() - start) + "ms");
            System.out.println(Thread.currentThread().getName() + ": " + i + " " + System.currentTimeMillis());
        }
    }
}
