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
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class PlayerItems extends JList {
    private final Player player;
    private final ArrayList<Item> items;
    private final DefaultListModel listModel;

    /**
     * Konstruktor. Nastavi pociatocne hodnoty
     * @param player 
     */
    public PlayerItems(Player player) {
        this.player = player;
        this.items = new ArrayList<Item>();
        this.listModel = new DefaultListModel();
        this.setModel(this.listModel);
        this.update();
        this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        this.getPlayerItems();
        this.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    System.out.println("wii");
                    System.out.println(PlayerItems.this.items.get(getSelectedIndex()).toString());
                }
            }
        });
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
     * Ziska predmety od hraca
     */
    protected void getPlayerItems() {
        Inventory playerInventory = this.player.getInventory();
        for (int i = 0; i < playerInventory.getCurrentSize(); i++) {
            this.addItem(playerInventory.getItem(i));
        }
    }
    
    /**
     * Vymaze predmety
     */
    private void clear() {
        this.listModel.removeAllElements();
        this.items.clear();
    }
    
    protected void addItem(Item item) {
        if (item == null) {
            return;
        }
        
        this.items.add(item);
    }
    
    public Player getPlayer() {
        return this.player;
    }
}
