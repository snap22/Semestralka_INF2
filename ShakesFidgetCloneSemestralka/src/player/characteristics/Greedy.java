/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.characteristics;

import basic.Chance;
import creatures.Player;


public class Greedy implements ICharacteristic {

    private int chanceToGetGold;
    private int goldAmount;

    public Greedy() {
        this.chanceToGetGold = 30;
        this.goldAmount = 1;
    }
    
    

    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToGetGold)) {
            player.addGold(this.goldAmount);
        }
    }

    @Override
    public int gainBonusDamage() {
        return 0;
    }

    @Override
    public void upgrade() {
        this.goldAmount += 2;
        
        if (this.chanceToGetGold >= 100) {
            return;
        }
        
        this.chanceToGetGold++;
    }

    @Override
    public String getPopis() {
        return String.format("Sanca ze dostane %d goldov: %d%n", this.goldAmount, this.chanceToGetGold);
    }
    
}
