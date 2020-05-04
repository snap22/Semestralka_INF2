
package sk.semestralka.shakelessmidget.items.slots;

import sk.semestralka.shakelessmidget.items.items.Item;

/**
 * Slot sluzi na ukladanie itemu do objeku, a jeho vymazanie
 * @author marce
 * @param <E> Predmet ktory si uklada
 */
public class Slot<E extends Item> {
    private E item;
    
    /**
     * Vytvori instanciu, ktora je zatial prazdna
     */
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
