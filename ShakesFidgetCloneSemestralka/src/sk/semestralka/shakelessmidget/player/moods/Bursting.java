
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.main.Chance;
import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Podtyp pre naladu
 */
public class Bursting extends Mood {

    
    private int chanceToCrit;
    private int amountOfDamage;
    

    /**
     * Vytvori naladu
     */
    public Bursting() {
        super("Bursting", 10, 90);
        this.chanceToCrit = 10;
    }
    
    /**
     * Sanca ze zvysi hracovi silu jeho utoku  o dvojnasobok jeho sily utoku
     * @param player hrac
     */
    @Override
    public void doSpecialStuff(Player player) {
        this.amountOfDamage = player.getDamage() * 2;
    }

    /**
     * Vrati bonusovy damage
     * @return bonusova sila utoku
     */
    @Override
    public int gainBonusDamage() {
        if (Chance.generate(this.chanceToCrit)) {
            return this.amountOfDamage;
        }
        return 0;
    }
    

    /**
     * Vrati popis nalady
     * @return popis
     */
    @Override
    public String getDescription() {
        return String.format("You have %d chance that you will deal extra damage", this.chanceToCrit);
    }
    
}
