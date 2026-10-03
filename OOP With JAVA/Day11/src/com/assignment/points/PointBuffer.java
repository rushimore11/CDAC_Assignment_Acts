package com.assignment.points;

public class PointBuffer {

    private static final int PAUSE_LIMIT = 250;
    private static final int RESUME_LIMIT = 15;

    private final MyLinkedList pointList = new MyLinkedList();

    public synchronized void addPoint(Point point) throws InterruptedException {

        // Pause producer when list size becomes more than 250.
        // Resume only when consumer reduces size to 15 or less.
        while (pointList.size() > PAUSE_LIMIT) {
            System.out.println(
                "Producer paused. List size = " + pointList.size()
                + ". Waiting until size is " + RESUME_LIMIT + " or less..."
            );

            wait();
        }

        pointList.addLast(point);

        System.out.println(
            "Produced -> " + point
            + " | List size: " + pointList.size()
        );

        notifyAll();
    }

    public synchronized Point removePoint() throws InterruptedException {

        while (pointList.isEmpty()) {
            System.out.println("Consumer waiting: list is empty...");
            wait();
        }

        Point point = pointList.removeFirst();

        System.out.println(
            "Consumed -> " + point
            + " | List size: " + pointList.size()
        );

        // Important: notify producer after consuming.
        // The producer resumes only after it sees size <= 15.
        if (pointList.size() <= RESUME_LIMIT) {
            System.out.println(
                "List size reached " + pointList.size()
                + ". Producer can resume."
            );
        }

        notifyAll();

        return point;
    }

    public synchronized int getSize() {
        return pointList.size();
    }
}