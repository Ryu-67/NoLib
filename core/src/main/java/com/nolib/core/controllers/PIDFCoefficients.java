package com.nolib.core.controllers;

public class PIDFCoefficients {

    double kP, kI, kD, kF;

    public PIDFCoefficients(double P, double I, double D, double F) {
        this.kP = P;
        this.kI = I;
        this.kD = D;
        this.kF = F;
    }

    public double getkP() {
        return kP;
    }

    public double getkI() {
        return kI;
    }

    public double getkD() {
        return kD;
    }
    public double getF() {
        return kF;
    }

}
