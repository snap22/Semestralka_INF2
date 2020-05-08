
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.main.Chance;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Podtyp pre naladu
 */
public class BloodThirsty extends Mood {

    private int chanceToHeal;

    /**
     * Vytvori naladu
     */
    public BloodThirsty() {
        super("BloodThirsty", 20, 100);
        this.chanceToHeal = 20;
    }
    
    

    /**
     * Healne playera o tolko kolko ma damage
     * @param player hrac
     */
    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToHeal)) {
            player.heal(player.getDamage());
        }
    }
    

    /**
     * Vrati popis nalady
     * @return popis
     */
    @Override
    public String getDescription() {
        return String.format("You have %d %% chance that you will heal yourself during an attack", this.chanceToHeal);
    }
    
}
