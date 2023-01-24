package com.nolib.core.wrappers;

import com.qualcomm.robotcore.hardware.Gamepad;

public class NoPad extends Gamepad {

    Gamepad gamepad;

    boolean isPressed;
    boolean toggled;
    boolean lastCheck;

    public NoPad(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public boolean toggle(boolean input) {
        if (!isPressed && input) {
            toggled = !toggled;
        }

        isPressed = input;

        return toggled;
    }

    public double increment(boolean one, boolean two, double val, double step) {
        if (!one && !two) {
            lastCheck = false;
        } else if (one && !lastCheck && val > 0.1) {
            val -= step;
            lastCheck = true;
        } else if (two && !lastCheck && val < 1) {
            val += step;
        }
        return val;
    }

}
