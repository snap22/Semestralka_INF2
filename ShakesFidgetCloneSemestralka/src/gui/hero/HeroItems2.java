/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;


import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 * Trieda HeroItems sluzi na zobrazenie equipnutych predmetov hraca, specialny pripad pre PlayerItems
 */
public class HeroItems2 extends PlayerItems {

    //private final Player player;
    

    /**
     * Konstruktor. Nastavi pociatocne hodnoty
     * @param player 
     */
    public HeroItems2(Player player) {
        super(player);
        this.getPlayerItems();
        super.changeSize(10, 10);
        this.setVisibleRowCount(3);
        
        for (int i = 0; i < player.getInventory().getCurrentSize(); i++) {
            System.out.println(player.getInventory().getItem(i));
        }
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

