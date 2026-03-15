package com.narxoz.rpg.hero;

public class HeroProfile {
    private final String name;
    private int health;
    private int speed;

    public HeroProfile(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void takeDamage(int amount) {
        health -= amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
