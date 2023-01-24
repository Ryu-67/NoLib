package com.nolib.core.actions.base;

import java.util.ArrayList;

public class AsyncActionSet extends Action{

    ArrayList<Action> actions;

    boolean isFinished;

    public AsyncActionSet (ArrayList<Action> actions) {
        this.actions = actions;
        for (Action action : actions) {
            action.setType(ActionType.async);
        }
    }

    @Override
    public void init() {
        for (Action action : actions) {
            action.init();
        }
    }

    @Override
    public void run() {
        for (Action action : actions) {
            action.run();
        }
    }

    @Override
    public boolean isFinished() {

        boolean check = false;

        for (Action action : actions) {
            if (!action.isFinished()) {
                check = false;
                break;
            } else {
                check = true;
            }
        }

        return check;
    }

}
