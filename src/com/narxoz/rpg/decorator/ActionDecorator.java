package com.narxoz.rpg.decorator;

public abstract class ActionDecorator implements AttackAction {
    private final AttackAction wrappedAction;

    protected ActionDecorator(AttackAction wrappedAction) {
        this.wrappedAction = wrappedAction;
    }

    protected AttackAction getWrappedAction() {
        return wrappedAction;
    }

    @Override
    public String getActionName() {
        //Delegate to wrapped action, then extend if needed.
        return wrappedAction.getActionName();
    }

    @Override
    public int getDamage() {
        //Delegate to wrapped action, then extend if needed.
        return wrappedAction.getDamage();
    }

    @Override
    public String getEffectSummary() {
        //Delegate to wrapped action, then extend if needed.
        return wrappedAction.getEffectSummary();
    }
}
