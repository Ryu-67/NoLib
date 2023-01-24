package com.nolib.core.pathing.followers;

import com.nolib.core.controllers.PIDFCoefficients;
import com.nolib.core.controllers.PIDFController;
import com.nolib.core.math.funcs.AngleWrapper;
import com.nolib.core.math.positions.Point;
import com.nolib.core.pathing.Path;

import java.util.ArrayList;
import java.util.HashMap;

public class PIDFFollower {

    PIDFController xController;
    PIDFController yController;
    PIDFController angleController;

    public PIDFFollower (PIDFCoefficients translational, PIDFCoefficients heading) {
        xController = new PIDFController(translational);
        yController = new PIDFController(translational);
        angleController = new PIDFController(heading);
    }

    public PIDFFollower (PIDFCoefficients x, PIDFCoefficients y, PIDFCoefficients heading) {
        xController = new PIDFController(x);
        yController = new PIDFController(y);
        angleController = new PIDFController(heading);
    }

    Point target;

    public HashMap<String, Double> update(Point currentPose) {
        Point focus = this.getTarget();

        double x = xController.output(focus.getX(), currentPose.getX());
        double y = yController.output(focus.getY(), currentPose.getY());
        double theta = angleController.angleOutput(focus.getTheta(), currentPose.getTheta());

        double x_rotated = x * Math.cos(-currentPose.getTheta()) - y * Math.sin(-currentPose.getTheta());
        double y_rotated = x * Math.sin(-currentPose.getTheta()) + y * Math.cos(-currentPose.getTheta());

        HashMap<String, Double> outputPowers = new HashMap<String, Double>();

        outputPowers.put("fl", x_rotated + y_rotated + theta);
        outputPowers.put("bl", x_rotated - y_rotated + theta);
        outputPowers.put("fr", x_rotated - y_rotated - theta);
        outputPowers.put("br", x_rotated + y_rotated - theta);

        return outputPowers;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    public Point getTarget() {
        return target;
    }

    public boolean segmentCompleteRigid (Point pose2D, Point currentGoal, double tolerance) {

        boolean x = false;
        boolean y = false;
        boolean angle = false;

        boolean complete = false;

        if (Math.abs(currentGoal.getX()) - Math.abs(pose2D.getX()) >= tolerance) {
            x = true;
        }

        if (Math.abs(currentGoal.getY()) - Math.abs(pose2D.getY()) >= tolerance) {
            y = true;
        }

        if (Math.abs(currentGoal.getTheta()) - Math.abs(pose2D.getTheta()) <= tolerance) {
            angle = true;
        }

        if (x && y && angle) {
            complete = true;
        }

        return complete;
    }

    boolean firstRun = true;

    Point pose;

    public void setPose(Point pose) {
        this.pose = pose;
    }

    public Point getPose() {
        return pose;
    }

    public Point processTarget(Path path, Point pose) {
        if (path.length() < 2) {
            if (segmentCompleteRigid(pose, path.get(0), 0.1)) {
                path.next();
                return path.get(0);
            } else {
                return path.get(0);
            }
        } else {
            return pose;
        }
    }

    public boolean isPathComplete(Path path, Point pose) {
        if (path.length() < 2) {
            return segmentCompleteRigid(pose, path.get(0), 0.1);
        } else {
            return false;
        }
    }

}
