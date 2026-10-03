package com.assignment.points;

public class ProducerThread extends Thread {

    private static final int AMPLITUDE = 100;
    private static final double PIE = 3.14;
    private static final int ANGLE_STEP = 3;

    private final PointBuffer pointBuffer;
    private final int frequency;

    private int angle = 0;
    private int xPoint = 0;

    public ProducerThread(PointBuffer pointBuffer, int frequency) {
        super("ProducerThread");
        this.pointBuffer = pointBuffer;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                double yPoint = AMPLITUDE * Math.sin((angle * PIE) / 180);

                Point point = new Point(xPoint, yPoint);

                pointBuffer.addPoint(point);

                // xPoint increments by multiples of 2 based on frequency.
                xPoint += 2 * frequency;

                angle += ANGLE_STEP;

                // Reset angle after reaching 360.
                if (angle > 360) {
                    angle = 0;
                }

                // Small delay makes output readable.
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("ProducerThread stopped.");
        }
    }
}