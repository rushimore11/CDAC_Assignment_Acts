package com.assignment.points;

public class ConsumerThread extends Thread {

    private final PointBuffer pointBuffer;

    public ConsumerThread(PointBuffer pointBuffer) {
        super("ConsumerThread");
        this.pointBuffer = pointBuffer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                Point point = pointBuffer.removePoint();

                // Point was already removed from the list by removePoint().
                System.out.println("Displaying point: " + point);

                // Make consumer slower than producer so the queue can exceed 250.
                Thread.sleep(80);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("ConsumerThread stopped.");
        }
    }
}