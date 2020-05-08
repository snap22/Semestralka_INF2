
package sk.semestralka.shakelessmidget.items.slots;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.items.items.Item;
import java.util.ArrayList;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import sk.semestralka.shakelessmidget.loaders.ItemLoader;


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
     * @throws InventoryFullException
     */
    public void addItem(Item item) throws InventoryFullException {
        if (this.slots.size() >= this.size) {
            throw new InventoryFullException();
        }
        
        if (item == null) {
            return;
        }
        
        this.slots.add(item);
        
    }
    /**
     * Vymaze item na danom indexe v iventory
     * @param index index
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
     * @return je plny inventar
     */
    public boolean isFull() {
        return this.slots.size() == this.size;
    }
    
    /**
     * Vrati item podla zadaneho indexu
     * @param index index
     * @return predmet
     */
    public Item getItem(int index) {
        if (index < 0 || index >= this.slots.size()) {
            return null;
        }
        
        return this.slots.get(index);
    }
    
    /**
     * Vrati pocet zaplnenych miest
     * @return aktualny pocet zaplnenych miest
     */
    public int getCurrentSize() {
        return this.slots.size();
    }
    
    /**
     * Vrati maximalne mnozstvo ktore moze mat hrac
     * @return maximalne mnozstvo zaplnitelnych miest
     */
    public int getMaxSize() {
        return this.size;
    }

    /**
     * Nacita itemy a prida ich do inventory
     * @param file subor
     * @throws IOException
     * @throws WrongTypeException 
     */
    public void load(DataInputStream file) throws IOException, WrongTypeException {
        this.slots.clear(); //vyprazdni inventory  
        ItemLoader itemCreator = new ItemLoader();
        int sizeOfInventory = file.readInt();
        for (int i = 0; i < sizeOfInventory; i++) {
            Item newItem = itemCreator.createItem(file);
            this.slots.add(newItem);
        }
    }

    /**
     * Ulozi itemy
     * @param file subor
     * @throws IOException 
     */
    public void save(DataOutputStream file) throws IOException {
        file.writeInt(this.slots.size());
        for (Item item : this.slots) {
            item.save(file);
        }
    }
    
    
        
}
