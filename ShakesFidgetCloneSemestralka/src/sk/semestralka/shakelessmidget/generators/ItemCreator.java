/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.generators;

import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import java.io.DataInputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.items.Goods;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;


/**
 *
 * @author marce
 */
public class ItemCreator {

    public ItemCreator() {
    }
    
    public Item createItem(DataInputStream file) throws IOException, WrongTypeException {
        String type = file.readUTF();
        Item newItem = this.loadEquipment(file, type);
        return newItem;
    }
    
    
    
    private Item loadEquipment(DataInputStream file, String type) throws IOException, WrongTypeException {
        String itemName = file.readUTF();
        ItemRarity rarity = ItemRarity.valueOf(file.readUTF());
        int goldValue = file.readInt();
        int armor = file.readInt();
        int damage = file.readInt();
        int health = file.readInt();
        int levelRequired = file.readInt();
        //chybicka se vbloudila pre Goods je toto cele zle!
        
        switch (type) {
            case "weapon":
                return new Weapon(itemName, rarity, damage, levelRequired, goldValue);
            case "armor":
                return new Armor(itemName, rarity, health, armor, levelRequired, goldValue);
            case "helmet":
                return new Helmet(itemName, rarity, health, armor, levelRequired, goldValue);
            case "goods":
                return new Goods(itemName, rarity, goldValue);
            default:
                throw new WrongTypeException();
        }
    }
    
    
    
   
    
}
