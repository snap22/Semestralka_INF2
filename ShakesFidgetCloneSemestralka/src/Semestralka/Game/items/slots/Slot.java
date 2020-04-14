/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka.game.items.slots;

import semestralka.game.items.Item2;

/**
 * Slot sluzi na ukladanie itemu do objeku, a jeho vymazanie
 * @author marce
 */
public class Slot<E extends Item2> {
    private E item;
    
    public Slot() {
        this.item = null;
    }
    
    public void insert(E item) {
        if (item == null) {
            return;
        }
        
        this.item = item;
    }
    
    /**
     * Vymaze item zo slotu a returne ho
     * @return vymazany item
     */
    public E remove() {
        E removedItem = this.item;
        this.item = null;
        return removedItem;
    }
    
    /**
     * Vrati hodnotu ci je slot prazdny
     * @return 
     */
    public boolean isEmpty() {
        return this.item == null;
    }
    
    /**
     * Vrati item ktory sa nachadza v slote
     * @return 
     */
    public E getItem() {
        return this.item;
    }
}
