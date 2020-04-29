/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.player.basic.Player;


public class Suicidal extends Mood {
    private int chanceToDie;
    
    public Suicidal() {
        super("Suicidal", 50, 25);
        this.chanceToDie = 50;
    }

    /**
     * Je urcita sanca ze hrac pocas toho ako utoci sa zabije
     * @param player 
     */
    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToDie)) {
            player.die();
        }
        
    }

    @Override
    public String getDescription() {
        return String.format("You have %d chance that you will die during an attack.", this.chanceToDie);
    }

    
}
    

