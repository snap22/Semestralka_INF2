/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.specialCharacteristics;


import creatures.Player;

/**
 *
 * @author marce
 */
public class SpecialCharacteristic {
    private int chance;
    private int bonusDamage;
    private String name;
    private Player player;
    private final int limit;

    public SpecialCharacteristic(String name, int chance, int limit, int bonusDamage) {
        this.chance = chance;
        this.name = name;
        this.limit = limit;
        this.bonusDamage = bonusDamage;
    }

    
    public void doSpecialStuff(Player player) {
        
    }

    
    public int gainBonusDamage() {
        return this.bonusDamage;
    }

    
    public void upgrade() {
        if (this.chance > this.limit) {
            return;
        }
        this.chance++;
    }

    
    public String getPopis() {
        return String.format("%S - so sancou: %d %n", this.name, this.chance);
    }
}
