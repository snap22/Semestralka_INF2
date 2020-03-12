/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.characteristics;

import basic.Chance;
import creatures.Player;


public class Bursting implements ICharacteristic {

    
    private int chanceToCrit;
    private int amountOfDamage;
    

    public Bursting() {
        this.chanceToCrit = 10;
    }
    
    

    @Override
    public void doSpecialStuff(Player player) {
        this.amountOfDamage = player.getDamage() * 2;
    }

    @Override
    public int gainBonusDamage() {
        if (Chance.generate(this.chanceToCrit)) {
            return this.amountOfDamage;
        }
        return 0;
    }

    @Override
    public void upgrade() {
        if (this.chanceToCrit >= 90) {
            return;
        }
        this.chanceToCrit++;
    }

    @Override
    public String getPopis() {
        return String.format("Sanca na critical strike: %d %n", this.chanceToCrit);
    }
    
}
