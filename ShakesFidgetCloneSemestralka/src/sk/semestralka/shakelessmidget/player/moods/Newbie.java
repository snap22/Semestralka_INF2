/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;


import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Podtyp pre naladu
 */
public class Newbie extends Mood {

    /**
     * Vytvori naladu
     */
    public Newbie() {
        super("Newbie", 1, 100);
    }
    
    @Override
    public void doSpecialStuff(Player player) {
        
    }

    @Override
    public String getDescription() {
        return String.format("You have %d chance for.. Never mind, nothing is going to happen.", super.getChance());
    }

    
    
    
    
}
