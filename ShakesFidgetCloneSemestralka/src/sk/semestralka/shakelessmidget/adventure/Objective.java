/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.creatures.Enemy;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.items.items.Item;

import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda Objective sluzi ako uloha pre hraca ktoru musi splnit
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
     * Kazda uloha bude mat nazov, popis misie, bytost ktoru treba zabit (bytost nemoze byt hrac!), 
     * odmena v goldoch a xp, a aky cas trva kym sa zacne misia
     * @param name nazov ulohy
     * @param description popis ulohy
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
    
    /**
     * Kazda uloha bude mat nazov, popis misie, bytost ktoru treba zabit (bytost nemoze byt hrac!), 
     * odmena v goldoch a xp, a aky cas trva kym sa zacne misia. Alternativny konstruktor bez popisu ulohy
     * @param name nazov ulohy
     * @param enemy nepriatel - nemoze to byt hrac
     * @param goldReward odmena v goldoch
     * @param xpReward odmena v xp
     * @param duration  cas trvania 
     */
    public Objective(String name, Enemy enemy, int goldReward, int xpReward, int duration) {
        this(name, "Too expensive to afford description!", enemy, goldReward, xpReward, duration);
    }
    
    /**
     * Splni ulohu
     */
    public void complete() {
        this.completed = true;
    }
    
    /**
     * Odmeni hraca
     * @param player hrac
     */
    public void giveReward(Player player) {
        if (!this.completed) {
            return;
        }
        int xp = this.xpReward + this.enemy.getXpReward();
        Item item = this.enemy.dropItem();
        
        try {
            player.addReward(xp, this.goldReward, item);
        } catch (InventoryFullException ex) {
            player.addXp(xp);
            player.addGold(this.goldReward);
        }
        
        this.status.append(String.format("You did it! Your reward is: %d xp, %d gold %n", xp, this.goldReward));
        if (item != null) {
            this.status.append(String.format("Yay! You also get: %s %n", item.toString()));
        }
        
    }

    /**
     * Vrati nepriatela
     * @return nepriatel
     */
    public Creature getEnemy() {
        return this.enemy;
    }

    /**
     * Vrati odmenu goldov
     * @return gold
     */
    public int getGoldReward() {
        return this.goldReward;
    }

    /**
     * Vrati odmenu xp
     * @return xp
     */
    public int getXpReward() {
        return this.xpReward;
    }

    /**
     * Vrati cas trvania ulohy
     * @return cas trvania
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Vrati nazov ulohy
     * @return nazov
     */
    public String getName() {
        return this.name;
    }

    /**
     * Vrati popis ulohy
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Vrati boolean ci je splnena uloha
     * @return splnenie
     */
    public boolean isCompleted() {
        return this.completed;
    }

    /**
     * Vrati status ulohy
     * @return status v podobe Stringu
     */
    public String getStatus() {
        return this.status.toString();
    }
    
    
    
    
    
    
    
    
}
