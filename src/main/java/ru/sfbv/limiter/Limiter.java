package ru.sfbv.limiter;

/**
 * @author Boris Fedorov
 */
public class Limiter {

    private final long delta;
    private long last = 0;

    public Limiter(int n, long t) {
        this.delta = t / n;
    }

    public synchronized void limit() {
        long millis = last + delta - System.currentTimeMillis();
        if (millis > 0) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        last = System.currentTimeMillis();
    }
}
