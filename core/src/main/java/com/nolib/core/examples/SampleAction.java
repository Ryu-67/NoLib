package com.nolib.core.examples;

import android.util.Range;

import com.nolib.core.actions.base.Action;
import com.nolib.core.controllers.PIDFController;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SampleAction extends Action {

    int target;

    double targetAsDouble;

    SampleSystem system;

    PIDFController controller;

    public SampleAction(SampleSystem system, int target) {
        this.system = system;
        this.target = target;
        this.targetAsDouble = target;
    }

    @Override
    public void init() {
        controller = system.getController();
    }

    @Override
    public void run() {
        system.motorEx.setPower(controller.output(targetAsDouble, system.motorEx.getCurrentPosition()));
    }

    @Override
    public boolean isFinished() {

        double current = system.motorEx.getCurrentPosition();

        return current > target - 2 && current < target + 2;

    }

}
