package com.nolib.core.pathing.actions.std;

import com.nolib.core.math.positions.Point;
import com.nolib.core.pathing.actions.base.Action;

public class Waypoint extends Action {

    Point waypoint;
    Point pose;

    public Waypoint (Point waypoint) {
        this.waypoint = waypoint;
    }

    @Override
    public void run() {
        //TODO: INSERT PATH CODE
    }

    @Override
    public boolean isFinished() {
        return false;
        //TODO: Localizer LMAO (finna reuse rr)
    }
}
