/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;

/**
 *
 * @author marce
 */
public class Item {

    private final String name;
    private final int value;
    private final ItemType type;
    private boolean isEquipped;
    
    public Item(String name, ItemType type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.isEquipped = false;
    }
    
    public Item(String name, int value) {
        this(name, ItemType.TRASH, value);
    }
    
    public Item(String name) {
        this(name, ItemType.TRASH, 1);
    }
    
    public boolean equip() {
        if (this.type == ItemType.MATERIAL || this.type == ItemType.TRASH) {
            return false;
        }
        
        if (this.isEquipped) {
            return false;
        }
        
        this.isEquipped = true;
        System.out.println("Uspesne equipnuty predmet");
        return true;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public ItemType getType() {
        return this.type;
    }

    public boolean isEquipped() {
        return this.isEquipped;
    }
    
    
}
