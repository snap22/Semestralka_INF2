/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import items.equippable.Armor;
import items.equippable.Equipment;
import items.equippable.Helmet;
import items.equippable.Weapon;
import items.valuables.Goods;
import java.util.Random;

/**
 * Generuje itemy..
 */
public abstract class ItemGenerator {
    private String[] adjectives = {"Iron", "Golden", "Wooden", "Elemental", "Magical", "Overpowered", "Majestic", "Astounishing", 
        "Stone", "Brutal", "Bloody", "Savage", "Empowered", "Practical", "Diamon", "Gladiator", "Training"};
    private String[] weaponNames = {"Sword", "Cleaver", "Axe", "Machette", "Mace", "Hammer"};
    private Random random  = new Random();
    
    public static Weapon generateWeapon() {
        
        return null;
    }
    
    public static Helmet generateHelmet() {
        return null;
    }
    
    public static Armor generateArmor() {
        return null;
    }
    
    public static Goods generateGoods() {
        return null;
    }
    
    public static Equipment generateEquipment() {
        return null;
    }
    
    
    public static Item2 generateItem() {
        return null;
    }
}
