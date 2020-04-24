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
public class HeroItems extends JList {

    private final Player player;
    private final ArrayList<Item> items;
    private final DefaultListModel listModel;

    /**
     * Konstruktor. Nastavi pociatocne hodnoty
     * @param player 
     */
    public HeroItems(Player player) {
        this.player = player;
        this.items = new ArrayList<Item>();
        //this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.listModel = new DefaultListModel();
        this.setModel(this.listModel);
        //this.getPlayerItems();
        this.update();
        
        //this.listModel.add(0, "Hello");
        //this.listModel.add(1, "World");
        //System.out.println(" item " + this.player.getSlots().getHeadSlot().getItem());
        this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        test();
        
        this.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    System.out.println(items.get(getSelectedIndex()).toString());
                }
            }
        });
    }
    
    private void test() {
        this.getPlayerItems();
    }
    
    /**
     * Metoda sluzi na pridanie predmetov do zoznamu
     */
    public void update() {
        if (this.items.isEmpty()) {
            return;
        }
        
        this.clear();
        
        this.getPlayerItems();
        
        for (int item = 0; item < this.items.size(); item++) {
            this.listModel.add(item, this.items.get(item).getName());
        }
    }
    
    /**
     * Ziska equipnute predmety od hraca
     */
    private void getPlayerItems() {
        this.items.add(this.player.getSlots().getHeadSlot().getItem());
        this.items.add(this.player.getSlots().getArmorSlot().getItem());
        this.items.add(this.player.getSlots().getWeaponSlot().getItem());
        
        
    }
    
    /**
     * Vymaze predmety
     */
    private void clear() {
        this.listModel.removeAllElements();
        this.items.clear();
    }
    
    
    
    
    
}
