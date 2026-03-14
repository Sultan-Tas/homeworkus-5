package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        //Decide how this decorator changes the visible action name.
        return ("Poisonous " + super.getActionName());
    }

    @Override
    public int getDamage() {
        //Add poison-related behavior on top of wrapped damage.
        return (int) Math.ceil(super.getDamage()*1.25);
    }

    @Override
    public String getEffectSummary() {
        //Append or compose the poison effect description.
        return (super.getEffectSummary() + " & poisons");
    }
}
