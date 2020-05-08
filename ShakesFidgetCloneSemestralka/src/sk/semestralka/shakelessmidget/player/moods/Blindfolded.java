
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.main.Chance;
import sk.semestralka.shakelessmidget.creatures.Player;


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

    /**
     * Znizi hracovi silu utoku 
     * @param player hrac
     */
    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToMiss)) {
            this.playerDamage = player.getDamage();
        }
    }

    /**
     * Znizi damage playera na 0, teda player akoby missol
     * @return bonusova sila utoku
     */
    @Override
    public int gainBonusDamage() {
        return -this.playerDamage;
    }

    /**
     * Vrati popis nalady
     * @return popis
     */
    @Override
    public String getDescription() {
        return String.format("You have %d %% chance that you will miss", this.chanceToMiss);
    }
    
}
