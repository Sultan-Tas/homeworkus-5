package com.narxoz.rpg.enemy;

public class BossEnemy {
    private final String name;
    private int health;
    private final int attackPower;
    private int speed;

    public BossEnemy(String name, int health, int attackPower, int speed) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
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
