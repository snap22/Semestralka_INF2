/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.semestralka.shakelessmidget.player.basic;

import sk.semestralka.shakelessmidget.items.slots.PlayerSlots;




/**
 *
 * @author marce
 */
public class PlayerAttributes {
    private int bonusDamage;
    private int bonusHealth;
    
    private PlayerSlots playerSlots;
    
    private int bonusArmor;
    private final Player player;

    public PlayerAttributes(Player player) {
        this.player = player;
        this.playerSlots = new PlayerSlots(this.player);
        this.bonusDamage = 0;
        this.bonusHealth = 0;
        this.bonusArmor = 0;
    }
    
    public void changeHealth(int amount) {
        this.bonusHealth += amount;
    }
    
    public void changeDamage(int amount) {
        this.bonusDamage += amount;
    }

    
    
    //      gettery
    public int getBonusDamage() {
        return this.bonusDamage;
    }

    public int getBonusHealth() {
        return this.bonusHealth;
    }

    public PlayerSlots getPlayerSlots() {
        return this.playerSlots;
    }

    public int getBonusArmor() {
        return this.bonusArmor;
    }
    
    
    
    
    
    
    
    
}
