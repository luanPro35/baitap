package baitap.bai1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger counter = new AtomicInteger(0);
    void increment() {
        counter.incrementAndGet();
    }
    int getValue() {
        return counter.get();
    }
}
