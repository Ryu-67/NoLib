package com.nolib.core.examples;

import com.nolib.core.configs.SystemBase;
import com.nolib.core.controllers.PIDFCoefficients;
import com.nolib.core.controllers.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SampleSystem extends SystemBase {

    DcMotorEx motorEx;

    PIDFCoefficients coefficients = new PIDFCoefficients(1, 1, 1, 0.05);
    PIDFController controller = new PIDFController(coefficients);

    @Override
    public void init(HardwareMap hardwareMap, OpMode opMode) {
        motorEx = hardwareMap.get(DcMotorEx.class, "motor");
        opMode.telemetry.addLine("Motor initializeed!");
        opMode.telemetry.update();
    }

    @Override
    public void init(HardwareMap hardwareMap, LinearOpMode opMode) {
        motorEx = hardwareMap.get(DcMotorEx.class, "motor");
        opMode.telemetry.addLine("Motor initializeed!");
        opMode.telemetry.update();
    }

    public PIDFController getController() {
        return controller;
    }
}
