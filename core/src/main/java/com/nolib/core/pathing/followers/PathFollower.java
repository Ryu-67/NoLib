package com.nolib.core.pathing.followers;

import com.nolib.core.math.positions.Point;
import com.nolib.core.wrappers.NoMecanum;

import java.util.HashMap;

public class PathFollower {

    PIDFFollower follower;
    FeedforwardFollower fFollower;

    public PathFollower(PIDFFollower follower) {
        this.follower = follower;
    }

    public PathFollower(FeedforwardFollower follower) {
        this.fFollower = follower;
    }

    public void runToPoint(Point target, Point pose) {
        follower.setTarget(target);
        HashMap<String, Double> powers = follower.update(pose);

    }
}
