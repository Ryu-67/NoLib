package com.nolib.core.actions.std;

import com.nolib.core.actions.base.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Wait extends Action {

    double waitTime;

    ElapsedTime runtime = new ElapsedTime();

    public Wait (double milliseconds) {
        this.waitTime = milliseconds;
    }

    @Override
    public void init() {
        runtime.reset();
    }

    @Override
    public boolean isFinished() {
        return runtime.milliseconds() >= waitTime;
    }
}
