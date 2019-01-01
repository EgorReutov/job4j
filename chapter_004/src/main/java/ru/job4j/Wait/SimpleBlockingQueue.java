package ru.job4j.Wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private int maxSize;
    @GuardedBy("this")
    private Queue<T> queue;

    public SimpleBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }

    public synchronized boolean offer(T value) throws InterruptedException {
        while (this.queue.size() >= maxSize) {
            wait();
        }
        notify();
        return queue.offer(value);
    }

    public synchronized T poll() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        notify();
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
