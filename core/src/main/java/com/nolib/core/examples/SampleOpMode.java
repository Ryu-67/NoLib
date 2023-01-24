package com.nolib.core.examples;

import com.nolib.core.actions.base.building.ActionRunner;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class SampleOpMode extends OpMode {

    SampleSystem system = new SampleSystem();

    ActionRunner runner = ActionRunner.getInstance();

    @Override
    public void init() {
        system.init(hardwareMap, this);

        runner.schedule(
                new SampleAction(system, 100)
        );
    }

    @Override
    public void loop() {
        runner.run();
    }
}
