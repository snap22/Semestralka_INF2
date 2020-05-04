
package sk.semestralka.shakelessmidget.player.moods;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Podtyp pre naladu
 */
public class Suicidal extends Mood {
    private int chanceToDie;
    
    /**
     * Vytvori naladu
     */
    public Suicidal() {
        super("Suicidal", 30, 5);
        this.chanceToDie = 30;
    }

    /**
     * Je urcita sanca ze hrac pocas toho ako utoci sa zabije
     * @param player hrac
     */
    @Override
    public void doSpecialStuff(Player player) {
        if (Chance.generate(this.chanceToDie)) {
            player.die();
        }
        
    }
     /**
     * Vrati popis nalady
     * @return 
     */
    @Override
    public String getDescription() {
        return String.format("You have %d chance that you will die during an attack.", this.chanceToDie);
    }

    
}
    

