/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import creatures.Creature;
import creatures.Imp;
import creatures.Player;

/**
 *
 * @author marce
 */
public class Mission {
    
    private Creature enemy;
            
    private int goldReward;
    private int xpReward;
    private int duration;
    private final String name;
    private final String description;
    private boolean completed;

    /**
     * Kazda misia bude mat nazov, popis misie, bytost ktoru treba zabit (bytost nemoze byt hrac!), 
     * odmena v goldoch a xp, a aky cas trva kym sa zacne misia
     * @param name nazov misie
     * @param description popis misie
     * @param enemy nepriatel - nemoze to byt hrac
     * @param goldReward odmena v goldoch
     * @param xpReward odmena v xp
     * @param duration  cas trvania 
     */
    public Mission(String name, String description, Creature enemy, int goldReward, int xpReward, int duration) {
        this.name = name;
        this.description = description;
        
        this.goldReward = goldReward;
        this.xpReward = xpReward;
        this.duration = duration;
        
        if (enemy instanceof Player) {
            this.enemy = new Imp("Imp", 20, 10);
        } else {
            this.enemy = enemy;
        }
    }
    
    /**
     * Splni misiu
     */
    public void complete() {
        this.completed = true;
    }
    
    /**
     * Odmeni hraca
     * @param player 
     */
    public void giveReward(Player player) {
        if (!this.completed) {
            return;
        }
        player.addXp(this.xpReward);
        player.addGold(this.goldReward);
        
    }

    public Creature getEnemy() {
        return this.enemy;
    }

    public int getGoldReward() {
        return this.goldReward;
    }

    public int getXpReward() {
        return this.xpReward;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return this.completed;
    }
    
    
    
    
    
    
}
