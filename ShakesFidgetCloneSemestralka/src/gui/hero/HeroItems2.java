/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sk.semestralka.shakelessmidget.player.basic.Player;
import sk.semestralka.shakelessmidget.items.items.Item;

/**
 * Trieda HeroItems sluzi na zobrazenie predmetov hraca
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

