
package sk.semestralka.shakelessmidget.a.gui.hero;


import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda HeroEquippedItems sluzi na zobrazenie equipnutych predmetov hraca, specialny pripad pre HeroInventoryItems
 */
public class HeroEquippedItems extends HeroInventoryItems {

    /**
     * Konstruktor. Nastavi pociatocne hodnoty
     * @param player 
     */
    public HeroEquippedItems(Player player) {
        super(player);
        this.getPlayerItems();
        this.getList().setVisibleRowCount(3);
        
        
    }
    
    /**
     * Ziska equipnute predmety od hraca
     */
    @Override
    protected void getPlayerItems() {
        super.addItem(super.getPlayer().getSlots().getHeadSlot().getItem());
        super.addItem(super.getPlayer().getSlots().getArmorSlot().getItem());
        super.addItem(super.getPlayer().getSlots().getWeaponSlot().getItem());  
    } 
    
}

