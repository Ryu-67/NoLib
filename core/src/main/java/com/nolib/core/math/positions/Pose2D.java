package com.nolib.core.math.positions;

public class Pose2D {

    Point pose;

    public Pose2D(double x, double y, double heading) {
        this.pose = new Point(x, y, heading);
    }

    public void setPose(double x, double y, double heading) {
        this.pose.setPoint(x, y, heading);
    }

    public double getX() {
        return this.pose.getX();
    }

    public double getY() {
        return this.pose.getY();
    }
    public double getTheta() {
        return this.pose.getTheta();
    }

    public Point poseToPoint () {
        return new Point(this.getX(),
                this.getY(),
                this.getTheta());
    }

    public Pose2D pointToPose (Point point) {
        return new Pose2D(point.getX(),
                point.getY(),
                point.getTheta());
    }

}
