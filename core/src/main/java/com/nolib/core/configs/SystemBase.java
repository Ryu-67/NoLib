package com.nolib.core.configs;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SystemBase {

    public void init(HardwareMap hardwareMap, OpMode opMode) {
        try {
            opMode.telemetry.addLine("default init");
        } catch (Exception e) {
            opMode.telemetry.addLine("init failed");
        }
        opMode.telemetry.update();
    }

    public void init(HardwareMap hardwareMap, LinearOpMode opMode) {
        try {
            opMode.telemetry.addLine("default init");
        } catch (Exception e) {
            opMode.telemetry.addLine("init failed");
        }
        opMode.telemetry.update();
    }
}
