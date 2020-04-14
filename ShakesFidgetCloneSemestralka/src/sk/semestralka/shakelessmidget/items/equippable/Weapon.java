/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.equippable;

import sk.semestralka.shakelessmidget.items.items.ItemRarity;


public class Weapon extends Equipment {

    

    public Weapon(String name, ItemRarity rarity, int levelRequired) {
        super(name, rarity, 1, 0, 0, levelRequired);
    } 
    
    public Weapon() {
        this("Training Sword", ItemRarity.COMMON, 0);
    }

    @Override
    public String toString() {
        return String.format("Weapon{%s, damage= %d, rarity= %s, value= %d , required level= %d}", 
                super.getName(), super.getBonusDamage(), super.getRarity(), 
                super.getGoldValue(), super.getLevelRequired());
    }
    
    
    
}