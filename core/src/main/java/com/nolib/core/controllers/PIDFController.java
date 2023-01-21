package com.nolib.core.controllers;

import com.nolib.core.controllers.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDFController {

    double kP, kI, kD, kF;

    double integral;

    double prevError;
    double lastSetTarget;

    ElapsedTime runtime = new ElapsedTime();

    public PIDFController(double P, double I, double D, double F) {
        this.kP = P;
        this.kI = I;
        this.kD = D;
        this.kF = F;
    }

    public PIDFController(PIDFCoefficients coefficients) {
        this.kP = coefficients.getkP();
        this.kI = coefficients.getkI();
        this.kD = coefficients.getkD();
        this.kF = coefficients.getF();
    }

    public double output (double reference_point, double current_position) {

        //Calculate the amount of error in our system, or the proportional term.
        double error = reference_point - current_position;

        //Prevent ridiculous integral windup (thanks, ctrl alt ftc)
        if (lastSetTarget != reference_point) {
            integral = 0;
        }
        //calculate the integral term
        integral += error * runtime.seconds();

        //calculate the derivative term
        double derivative = (error - prevError) / runtime.seconds();

        //make sure to set our variables for the next loop.
        prevError = error;
        lastSetTarget = reference_point;

        runtime.reset();

        //return a useful output. be sure to call this func in a loop.
        return kP * error + kI * integral + kD * derivative + kF;
    }

    public void setPID (double P, double I, double D, double F) {
        this.kP = P;
        this.kI = I;
        this.kD = D;
        this.kF = F;
    }

}
