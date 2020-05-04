
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Podtyp pre naladu
 */
public class Greedy extends Mood {

    private int chanceToGetGold;
    private int goldAmount;

    /**
     * Vytvori naladu
     */
    public Greedy() {
        super("Greedy", 30, 100);
        this.chanceToGetGold = 30;
        this.goldAmount = 1;
    }

    /**
     * Sanca ze da hracovi bonusove peniaze
     * @param player 
     */
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
    
    /**
     * Vrati popis nalady
     * @return 
     */
    @Override
    public String getDescription() {
        return String.format("You have %d %% chance that you will get %d gold during an attack", this.chanceToGetGold, this.goldAmount);
    }
    
}
