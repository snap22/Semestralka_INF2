/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.slots;

import items.Item2;
import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class Inventory {
    private ArrayList<Slot<Item2>> slots;   //Treba arraylist zo slotov? nestaci arrayList z itemov?!
    private int size;
    
    public Inventory(int size) {
        this.slots = new ArrayList<Slot<Item2>>();
        this.size = size;
        
    }
    
    public Inventory() {
        this(8);
    }
    
    /**
     * Prida item do prveho volneho miesta v inventory
     * @param item 
     */
    public void addItem(Item2 item) {
        if (this.slots.size() >= this.size) {
            return;
        }
        
        if (item == null) {
            return;
        }
        
        for (Slot<Item2> slot : this.slots) {
            if (slot.isEmpty()) {
                slot.insert(item);
                return;
            }
        }
    }
    /**
     * Vymaze item na danom indexe v iventory
     * @param index 
     */
    public void removeItem(int index) {
        if (index < 0 || index >= this.slots.size()) {
            return;
        }
        this.slots.remove(index);
    }
    
    /**
     * Vymaze dany item z inventory ak sa v nom nachadza
     * @param item 
     */
    public void removeItem(Item2 item) {
        this.slots.remove(item);
    }
        
}
