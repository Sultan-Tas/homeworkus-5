package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        //Decide how this decorator changes the visible action name.
        return ("Flaming " + super.getActionName());
    }

    @Override
    public int getDamage() {
        //Add fire-related behavior on top of wrapped damage.
        return (int) Math.round(super.getDamage()*1.5);
    }

    @Override
    public String getEffectSummary() {
        //Append or compose the fire effect description.
        return (super.getEffectSummary() + " & ignites");

    }
}
