package com.nolib.core.wrappers;

import com.qualcomm.robotcore.hardware.DcMotor;

public class NoMecanum {

    DcMotor frontLeft, frontRight, backLeft, backRight;

    public NoMecanum (DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    public void fieldCentric (double forward, double strafe, double turn, double heading, double mult) {

        forward = forward * -1;

        double rotX = strafe * Math.cos(heading) - forward * Math.sin(heading);
        double rotY = strafe * Math.sin(heading) + forward * Math.cos(heading);

        double ratioFix = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1);
        double frontLeftPower = (rotY + rotX + turn) / ratioFix;
        double backLeftPower = (rotY - rotX + turn) / ratioFix;
        double frontRightPower = (rotY - rotX - turn) / ratioFix;
        double backRightPower = (rotY + rotX - turn) / ratioFix;

        frontLeft.setPower(frontLeftPower*mult);
        backLeft.setPower(backLeftPower*mult);
        frontRight.setPower(frontRightPower*mult);
        backRight.setPower(backRightPower*mult);
    }



}
