/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.slots;

import sk.semestralka.shakelessmidget.items.items.Item;
import java.util.ArrayList;


/**
 * Trieda Inventory sluzi na ukladanie predmetov hraca
 */
public class Inventory {
    private int size;
    private ArrayList<Item> slots;
    
    /**
     * Vytvori instanciu podla danej hodnoty
     * @param size velkost inventory
     */
    public Inventory(int size) {
        if (size <= 0) {
            size = 1;
        }
        
        this.slots = new ArrayList<Item>();
        this.size = size;
        
    }
    
    /**
     * Vytvori instanciu s preddefinovanou hodnotou (8)
     */
    public Inventory() {
        this(8);
    }
    
    /**
     * Prida item do prveho volneho miesta v inventory
     * @param item predmet
     */
    public void addItem(Item item) {
        if (this.slots.size() >= this.size) {
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
     * @param item predmet
     */
    public void removeItem(Item item) {
        if (item == null) {
            return;
        }
        
        if (!this.slots.contains(item)) {
            return;
        }
        
        this.slots.remove(item);
    }
    
    /**
     * Vrati booelan ci je plny
     * @return 
     */
    public boolean isFull() {
        return this.slots.size() == this.size;
    }
    
    /**
     * Vrati item podla zadaneho indexu
     * @param index 
     * @return 
     */
    public Item getItem(int index) {
        if (index < 0 || index >= this.slots.size()) {
            return null;
        }
        
        return this.slots.get(index);
    }
    
    /**
     * Vrati pocet zaplnenych miest
     * @return 
     */
    public int getCurrentSize() {
        return this.slots.size();
    }
    
    /**
     * Vrati maximalne mnozstvo ktore moze mat hrac
     * @return 
     */
    public int getMaxSize() {
        return this.size;
    }
    
    
        
}
