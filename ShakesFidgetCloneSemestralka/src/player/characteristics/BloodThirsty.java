/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.characteristics;

import basic.Chance;
import creatures.Player;


public class BloodThirsty implements ICharacteristic {

    private int chanceToHeal;

    public BloodThirsty() {
        this.chanceToHeal = 20;
    }
    
    

    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToHeal)) {
            player.heal(player.getDamage());
        }
    }

    @Override
    public int gainBonusDamage() {
        return 0;
    }

    @Override
    public void upgrade() {
        if (this.chanceToHeal >= 100) {
            return;
        }
        this.chanceToHeal++;
    }

    @Override
    public String getPopis() {
        return String.format("Sanca ze sa healne: %d%n", this.chanceToHeal);
    }
    
}
