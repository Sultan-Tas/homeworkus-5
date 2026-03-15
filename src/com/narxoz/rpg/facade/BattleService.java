package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        // Implement the battle flow.
        // Questions to answer:
        // - Who attacks first? (determined by speed)
        // - How many rounds are allowed? (10 cycles)
        // - How is damage resolved? (basic reduction from health. No stuff like damage reduction)
        // - How will randomness affect the result, if at all? (Crit. hits because crits are fair, but only for the player)
        AdventureResult result = new AdventureResult();
        //AV = Action Value
        int heroAV = 10000/ hero.getSpeed();
        int bossAV = 10000/ boss.getSpeed();
        int currentHeroAV = 0;
        int currentBossAV = 0;
        String currentMove = "";

        int roundThreshold = 0;
        int round = 0;

        while(hero.isAlive() && boss.isAlive()) {
            if(currentHeroAV <= currentBossAV) {
                currentMove = "hero";
                currentHeroAV += heroAV;
            }
            else{
                currentMove = "boss";
                currentBossAV += bossAV;
            }

            if(currentHeroAV >= roundThreshold || currentBossAV >= roundThreshold) {
                if(round != 0){
                    roundThreshold += 100;
                }
                else{
                    roundThreshold += 150;
                }
                round++;
                result.addLine("Round " + round);
            }
            if(currentMove.equals("hero")) {
                int DMG = action.getDamage();
                if (random.nextInt(100) < 20) {
                    DMG *= 2;
                }
                boss.takeDamage(DMG);
                result.addLine("\t[" + hero.getName() + "] dealt " + DMG + " damage to ►" + boss.getName());
            }
            else{
                int DMG = boss.getAttackPower();
                hero.takeDamage(DMG);

                result.addLine("\t[" + boss.getName() + "] dealt " + DMG + " damage to ►" + hero.getName());
            }
        }
        if(hero.isAlive()){
            result.setWinner("Hero [" + hero.getName() + "] won!");
        }
        else{
            result.setWinner("Boss [" + boss.getName() + "] won!");
        }
        result.setRounds(round);
        result.addLine("Adventure ended...");
        return result;
    }
}
