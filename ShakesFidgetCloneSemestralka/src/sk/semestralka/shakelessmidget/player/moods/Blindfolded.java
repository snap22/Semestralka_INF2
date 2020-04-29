/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.player.basic.Player;


/**
 * Podtyp pre naladu
 */
public class Blindfolded extends Mood {

    private int chanceToMiss;
    private int playerDamage;

    /**
     * Vytvori naladu
     */
    public Blindfolded() {
        super("BlindFolded", 50, 10);
        this.chanceToMiss = 50;
    }

    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToMiss)) {
            this.playerDamage = player.getDamage();
        }
    }

    /**
     * Znizi damage playera na 0, teda player akoby missol
     * @return 
     */
    @Override
    public int gainBonusDamage() {
        return -this.playerDamage;
    }

    @Override
    public void upgrade() {
        if (this.chanceToMiss <= 10) {
            return;
        }
        
        this.chanceToMiss--;
    }


    @Override
    public String getDescription() {
        return String.format("You have %d chance that you will miss", this.chanceToMiss);
    }
    
}
