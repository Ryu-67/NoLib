package com.nolib.core.util;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class NoCode {

    public void noCode(LinearOpMode linearOpMode) {
        linearOpMode.stop();
        linearOpMode.waitForStart();
    }

    public void noCode(OpMode opMode) {
        opMode.stop();
        opMode.init();
    }

}
