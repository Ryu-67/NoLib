package com.nolib.core.actions.base.building;

import com.nolib.core.actions.base.Action;
import com.nolib.core.actions.base.ActionType;

import java.util.ArrayList;

public final class ActionExecutor {

    ArrayList<Action> assemblyArray = new ArrayList<>();

    public static ActionExecutor instance;

    public static ActionExecutor getInstance() {
        return instance;
    }

    ArrayList<Action> scheduledActions = new ArrayList<>();

    public void schedule(Action... actions) {
        for (Action action : actions) {
            if (action.getType() == ActionType.null_action) {
                System.out.println("Exception!");
                return;
            }
        }
    }

    boolean initAction = true;

    public void run() {

        Action focus = assemblyArray.get(0);

        if (initAction) {
            focus.init();
            initAction = false;
        }

        if (assemblyArray.get(0).isFinished()) {
            assemblyArray.remove(0);
            initAction = true;
            focus = assemblyArray.get(0);
        }

        if (initAction) {
            focus.init();
            initAction = false;
        }

        focus.run();

    }
}
