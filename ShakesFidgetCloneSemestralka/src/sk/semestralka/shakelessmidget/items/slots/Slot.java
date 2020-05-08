
package sk.semestralka.shakelessmidget.items.slots;

import sk.semestralka.shakelessmidget.items.items.Item;

/**
 * Slot sluzi na ukladanie itemu do objeku, a jeho vymazanie
 * @author marce
 * @param <T> Predmet ktory si uklada
 */
public class Slot<T extends Item> {
    private T item;
    
    /**
     * Vytvori instanciu, ktora je zatial prazdna
     */
    public Slot() {
        this.item = null;
    }
    
    public void insert(T item) {
        if (item == null) {
            return;
        }
        
        this.item = item;
    }
    
    /**
     * Vymaze ppredmet zo slotu
     * @return vymazany predmet
     */
    public T remove() {
        T removedItem = this.item;
        this.item = null;
        return removedItem;
    }
    
    /**
     * Vrati hodnotu ci je slot prazdny
     * @return je prazdny
     */
    public boolean isEmpty() {
        return this.item == null;
    }
    
    /**
     * Vrati item ktory sa nachadza v slote
     * @return predmet
     */
    public T getItem() {
        return this.item;
    }
}
