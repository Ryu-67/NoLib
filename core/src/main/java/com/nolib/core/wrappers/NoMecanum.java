package com.nolib.core.wrappers;

import com.nolib.core.util.AxisDirection;
import com.nolib.core.util.BNO055IMUUtil;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class NoMecanum {

    DcMotor frontLeft, frontRight, backLeft, backRight;
    BNO055IMU imu;

    HardwareMap hardwareMap;
    Telemetry telemetry;

    public NoMecanum (HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
    }

    public void init(String frontLeft, String frontRight, String backLeft, String backRight, String imu,
                     boolean flReverse, boolean frReverse, boolean blReverse, boolean brReverse, AxisDirection zAxis) {
        try {
            this.frontLeft = hardwareMap.dcMotor.get(frontLeft);
            this.frontRight = hardwareMap.dcMotor.get(frontRight);
            this.backLeft = hardwareMap.dcMotor.get(backLeft);
            this.backRight = hardwareMap.dcMotor.get(backRight);

            this.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            this.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            this.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            this.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            this.imu = hardwareMap.get(BNO055IMU.class, imu);
            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
            this.imu.initialize(parameters);
            BNO055IMUUtil.remapZAxis(this.imu, zAxis );

        } catch (Exception e) {
            telemetry.addLine("Drive Intialization Failed");
            telemetry.update();
        }



    }


}
