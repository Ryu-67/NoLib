package com.nolib.core.pathing.actions.base;

import java.util.ArrayList;
import java.util.Arrays;

public class AsyncActionSet extends Action{

    Action action;

    boolean isFinished;

    public AsyncActionSet (Action actions) {
        this.action = actions;
        action.setType(ActionType.async);
    }

    @Override
    public void init() {
        action.init();
    }

    @Override
    public void run() {
        action.run();
    }

}
