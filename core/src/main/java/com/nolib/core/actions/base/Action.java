package com.nolib.core.actions.base;

@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public abstract class Action implements ActionBase {

    ActionType actionType;

    String name = this.getClass().getSimpleName();

    public void nullify() {
        actionType = ActionType.null_action;
    }

    public void setType(ActionType type) {
        this.actionType = type;
    }

    public String telem() {
        return name;
    }

    @Override
    public ActionType getType() {
        return actionType;
    }

}
