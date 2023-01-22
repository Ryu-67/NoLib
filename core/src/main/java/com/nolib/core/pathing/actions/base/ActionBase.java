package com.nolib.core.pathing.actions.base;

public interface ActionBase {

    default boolean isFinished() {
        return true;
    }

    default ActionType getType() {
        return ActionType.null_action;
    }

    default void run() {

    }

    default void init() {
        //do not use
    }


}
