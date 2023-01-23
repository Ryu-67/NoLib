package com.nolib.core.pathing.followers;

import com.nolib.core.controllers.PIDFCoefficients;
import com.nolib.core.controllers.PIDFController;
import com.nolib.core.math.funcs.AngleWrapper;
import com.nolib.core.math.positions.Point;

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
}
