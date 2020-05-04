
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
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
     * Sanca ze zvysi hracovi damage na dvojnasobok
     * @param player 
     */
    @Override
    public void doSpecialStuff(Player player) {
        this.amountOfDamage = player.getDamage() * 2;
    }

    /**
     * Vrati bonusovy damage
     * @return 
     */
    @Override
    public int gainBonusDamage() {
        if (Chance.generate(this.chanceToCrit)) {
            return this.amountOfDamage;
        }
        return 0;
    }
    /**
     * Vrati triedu v podobe stringu
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Sanca na critical strike: %d %n", this.chanceToCrit);
    }

    /**
     * Vrati popis nalady
     * @return 
     */
    @Override
    public String getDescription() {
        return String.format("You have %d chance that you will deal extra damage", this.chanceToCrit);
    }
    
}
