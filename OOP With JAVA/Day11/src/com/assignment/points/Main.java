package com.assignment.points;

public class Main {

    public static void main(String[] args) {

        int frequency = 2;

        PointBuffer pointBuffer = new PointBuffer();

        ProducerThread producerThread =
                new ProducerThread(pointBuffer, frequency);

        ConsumerThread consumerThread =
                new ConsumerThread(pointBuffer);

        producerThread.start();
        consumerThread.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            producerThread.interrupt();
            consumerThread.interrupt();

            System.out.println(
                "\nApplication stopped. Remaining points: "
                + pointBuffer.getSize()
            );
        }));
    }
}