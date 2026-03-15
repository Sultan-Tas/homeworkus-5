package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult.getWinner().contains("Boss")) {
            return "Loot:" +
                    "\tno loot for losers...";
        }
        else {
            return "Loot:\n" +
                    "\t5000 gold\n" +
                    "\t[Official tax evasion pardon]\n" +
                    "\t[Record of illegal bank operations]\n" +
                    "\t[Not suspicious note]";
        }
    }
}
