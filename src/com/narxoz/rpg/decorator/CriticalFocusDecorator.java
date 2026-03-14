package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        //Decide how this decorator changes the visible action name.
        return ("CRITICAL " + super.getActionName());
    }

    @Override
    public int getDamage() {
        //Add critical-related behavior on top of wrapped damage.
        return (int) Math.round(super.getDamage()*2.0);
    }

    @Override
    public String getEffectSummary() {
        //Append or compose the critical effect description.
        return (super.getEffectSummary() + " & deals CRITICAL damage");
    }
}
