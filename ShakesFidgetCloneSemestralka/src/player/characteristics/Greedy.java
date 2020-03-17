/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.characteristics;

import basic.Chance;
import player.basic.Player;



public class Greedy extends Mood {

    private int chanceToGetGold;
    private int goldAmount;

    public Greedy() {
        super("Greedy", 30, 100);
        this.chanceToGetGold = 30;
        this.goldAmount = 1;
    }

    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToGetGold)) {
            player.addGold(this.goldAmount);
        }
    }
    /**
     * Bude zvysovat sancu, ze mu padnu bonusove goldy, a taktiez pocet goldov kolko mu padne
     */
    @Override
    public void upgrade() {
        this.goldAmount += 2;
        
        if (this.chanceToGetGold >= 100) {
            return;
        }
        
        this.chanceToGetGold++;
    }

    @Override
    public String toString() {
        return String.format("Sanca ze dostane %d goldov: %d%n", this.goldAmount, this.chanceToGetGold);
    }
    
}
