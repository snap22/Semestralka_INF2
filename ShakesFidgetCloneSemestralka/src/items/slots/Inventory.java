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
    private int size;
    private ArrayList<Item2> slots;
    
    public Inventory(int size) {
        if (size <= 0) {
            size = 1;
        }
        
        this.slots = new ArrayList<Item2>();
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
        if (this.slots.size() > this.size) {
            return;
        }
        
        if (item == null) {
            return;
        }
        
        this.slots.add(item);
        
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
        if (item == null) {
            return;
        }
        
        if (!this.slots.contains(item)) {
            return;
        }
        
        this.slots.remove(item);
    }
    
    public boolean isFull() {
        return this.slots.size() == this.size;
    }
    
    public Item2 getItem(int index) {
        if (index < 0 || index >= this.slots.size()) {
            return null;
        }
        
        return this.slots.get(index);
    }
    
    public int getCurrentSize() {
        return this.slots.size();
    }
    
    public int getMaxSize() {
        return this.size;
    }
    
    
        
}
