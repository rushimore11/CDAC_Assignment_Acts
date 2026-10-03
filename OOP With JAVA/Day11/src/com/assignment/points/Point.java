package com.assignment.points;

public class Point {
    private final int xPoint;
    private final double yPoint;

    public Point(int xPoint, double yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    public int getXPoint() {
        return xPoint;
    }

    public double getYPoint() {
        return yPoint;
    }

    @Override
    public String toString() {
        return String.format("Point{xPoint=%d, yPoint=%.2f}", xPoint, yPoint);
    }
}