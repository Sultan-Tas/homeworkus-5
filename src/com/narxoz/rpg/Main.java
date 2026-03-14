package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

import java.nio.file.attribute.PosixFileAttributes;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        // TODO: Create a hero and a boss with your own meaningful stats.
        HeroProfile hero = new HeroProfile("Richard Lionheart", 100);
        BossEnemy boss = new BossEnemy("Tax Collector", 120, 15);

        // Start with a base action and then create several decorated versions.
        AttackAction basic = new BasicAttack("Strike", 10);
        AttackAction poisonFire = new PoisonCoatingDecorator(
                new FireRuneDecorator(basic)
        );
        AttackAction firePoison = new FireRuneDecorator(
                new PoisonCoatingDecorator(basic)
        );
        AttackAction critBasic = new CriticalFocusDecorator(basic);
        AttackAction critFire = new FireRuneDecorator(critBasic);
        AttackAction everything = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base action: " + basic.getActionName() +
                "\n\tdamage: " + basic.getDamage() +
                "\n\teffects: " + basic.getEffectSummary());
        System.out.println();
        System.out.println("Poison + Fire: " + poisonFire.getActionName() +
                "\n\tdamage: " + poisonFire.getDamage() +
                "\n\teffect: " + poisonFire.getEffectSummary());
        System.out.println();
        System.out.println("Fire + Poison: " + firePoison.getActionName() +
                "\n\tdamage: " + firePoison.getDamage() +
                "\n\teffect: " + firePoison.getEffectSummary());
        System.out.println();
        System.out.println("Fire applied on Crit: " + critFire.getActionName() +
                "\n\tdamage: " + critFire.getDamage() +
                "\n\teffect: " + critFire.getEffectSummary());
        System.out.println();
        System.out.println("Everything in one action: " + everything.getActionName() +
                "\n\tdamage: " + everything.getDamage() +
                "\n\teffects: " + everything.getEffectSummary());

        //Replace the placeholder preview above with richer proof of runtime composition.

        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, everything);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        // TODO: Expand this demo so it clearly proves:
        // 1) multiple decorator combinations
        // 2) one full dungeon run through the facade
        // 3) readable final summary

        System.out.println("\n=== Demo Complete ===");
    }
}
