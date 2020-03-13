/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.specialCharacteristics;

import basic.Chance;
import creatures.Player;


public class Suicidal extends Characteristic {
    private int chanceToDie;
    
    public Suicidal() {
        super("Suicidal", 50, 25, 0);
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

    /**
     * 
     * @return 0 pretoze tento character nedava bonus damage
     */
    @Override
    public int gainBonusDamage() {
        return 0;
    }

    /**
     * Znizi sancu ze sa zabije o 1, najnizsie sa moze znizit na 25% 
     */
    @Override
    public void upgrade() {
        if (this.chanceToDie <= 25) {
            return;
        }
        
        this.chanceToDie--;
        
    }

    @Override
    public String getPopis() {
        return String.format("Má %d šancu že počas útoku zomrie.%n", this.chanceToDie);
    }
    
}
    

