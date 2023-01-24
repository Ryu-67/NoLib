package com.nolib.core.actions.building;

import com.nolib.core.actions.base.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public final class ActionExecutor {

    ArrayList<Action> assemblyArray = new ArrayList<>();

    public static ActionExecutor instance;

    public static ActionExecutor getInstance() {
        return instance;
    }

    ArrayList<Action> scheduledActions = new ArrayList<>();

    public void schedule(Action... actions) {
        assemblyArray.addAll(Arrays.asList(actions));
    }

    public void run() {

    }
}
