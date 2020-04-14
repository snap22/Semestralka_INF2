/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.player.basic.Player;


public class BloodThirsty extends Mood {

    private int chanceToHeal;

    public BloodThirsty() {
        super("BloodThirsty", 20, 100);
        this.chanceToHeal = 20;
    }
    
    

    /**
     * Healne playera o tolko kolko ma damage
     * @param player 
     */
    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToHeal)) {
            player.heal(player.getDamage());
        }
    }

    @Override
    public String toString() {
        return String.format("Sanca ze sa healne: %d%n", this.chanceToHeal);
    }
    
}
