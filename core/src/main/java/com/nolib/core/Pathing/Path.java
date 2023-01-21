package com.nolib.core.Pathing;

import com.nolib.core.Math.positions.Point;

import java.util.ArrayList;

public class Path {

    ArrayList<Point> pointList = new ArrayList<Point>();

    public Path(ArrayList<Point> path) {
        this.pointList = path;
    }

    public void addPoint(double x, double y, double angle) {
        Point point = new Point(x, y, angle);
        this.pointList.add(point);
    }

    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        this.pointList.add(point);
    }

    public void addPoint(Point point) {
        this.pointList.add(point);
    }

    public void addAtIndex(Point point, int index) {
        this.pointList.add(index, point);
    }

    public void clear() {
        this.pointList.clear();
    }

    public Point get(int index) {
        return this.pointList.get(index);
    }

    public int length() {
        return this.pointList.size();
    }

    public void next() {
        this.pointList.remove(0);
    }

    public Point lookAhead() {
        return this.pointList.get(0);
    }

    public Point lookAheadTwice() {
        return this.pointList.get(1);
    }

    public ArrayList<Point> getPointList() {
        return this.pointList;
    }
}

