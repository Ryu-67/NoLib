package com.nolib.core.Math.geometry;


import com.nolib.core.Math.positions.Point;

public class Vector {

    double direction;
    double magnitude;
    double x;
    double y;

    Point origin;

    public Vector (double direction, double magnitude, double x, double y) {
        this.direction = direction;
        this.magnitude = magnitude;
        this.x = x;
        this.y = y;
    }

    public Vector (double direction, double magnitude, double x, double y, Point origin) {
        this.direction = direction;
        this.magnitude = magnitude;
        this.x = x;
        this.y = y;
        this.origin = origin;
    }

    public double getXMag() {
        return Math.cos(this.direction) * this.magnitude;
    }

    public double getYMag() {
        return Math.sin(this.direction) * this.magnitude;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point getOrigin() {
        return origin;
    }
}
