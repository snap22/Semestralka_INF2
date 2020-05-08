
package sk.semestralka.shakelessmidget.player.moods;


import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Podtyp pre naladu
 */
public class Newbie extends Mood {

    /**
     * Vytvori naladu
     */
    public Newbie() {
        super("Newbie", 1, 100);
    }
    
    /**
     * Nevykona nic
     * @param player  hrac
     */
    @Override
    public void doSpecialStuff(Player player) {
        
    }

    /**
     * Vrati popis nalady
     * @return popis
     */
    @Override
    public String getDescription() {
        return String.format("You have %d %% chance for.. Never mind, nothing is going to happen.", super.getChance());
    }

    
    
    
    
}
