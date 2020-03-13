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
    
    private boolean isEquippable;
    
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
        this.isEquippable = false;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isEquippable() {
        return this.isEquippable;
    }
    
    
}
