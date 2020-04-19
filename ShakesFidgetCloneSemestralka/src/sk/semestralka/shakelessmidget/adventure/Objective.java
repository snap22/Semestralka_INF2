/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.creatures.Enemy;
import sk.semestralka.shakelessmidget.items.items.Item2;

import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class Objective {
    
    private Enemy enemy;
            
    private int goldReward;
    private int xpReward;
    private int duration;
    private final String name;
    private final String description;
    private boolean completed;
    
    private StringBuilder status;

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
    public Objective(String name, String description, Enemy enemy, int goldReward, int xpReward, int duration) {
        this.name = name;
        this.description = description;
        this.goldReward = goldReward;
        this.xpReward = xpReward;
        this.duration = duration;
        this.enemy = enemy; 
        
        this.status = new StringBuilder();
    }
    
    public Objective(String name, Enemy enemy, int goldReward, int xpReward, int duration) {
        this(name, "Too expensive to afford description!", enemy, goldReward, xpReward, duration);
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
        int xp = this.xpReward + this.enemy.getXpReward();
        Item2 item = this.enemy.dropItem();
        
        player.addReward(xp, this.goldReward, item);
        this.status.append(String.format("You did it! Your reward is: %d xp, %d gold %n", xp, this.goldReward));
        if (item != null) {
            this.status.append(String.format("Yay! You also get: %s %n", item.toString()));
        }
        
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

    public String getStatus() {
        return this.status.toString();
    }
    
    
    
    
    
    
    
    
}
