package com.nolib.core.math.positions;

public class Point {

    public double x;
    public double y;
    public double theta;
    public boolean hasAngle = false;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
        hasAngle = true;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint(double x, double y, double theta) {
        hasAngle = true;
        this.theta = theta;
        this.x = x;
        this.y = y;
    }
    public void setPoint(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public Point add(Point point) {
        return new Point(this.x+point.x, this.y+point.y);
    }

    public Point subtract(Point point) {
        return new Point(this.x-point.x, this.y-point.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    public double getTheta() {
        return this.theta;
    }

}
