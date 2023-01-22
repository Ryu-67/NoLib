package com.nolib.core.pathing.actions.building;

import com.nolib.core.pathing.actions.base.Action;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionAssembly {

    ArrayList<Action> assemblyArray = new ArrayList<>();

    public ActionAssembly (Action... actions) {
        this.assemblyArray.addAll(Arrays.asList(actions));
    }

    public Action currentAction() {
        return assemblyArray.get(0);
    }

}
