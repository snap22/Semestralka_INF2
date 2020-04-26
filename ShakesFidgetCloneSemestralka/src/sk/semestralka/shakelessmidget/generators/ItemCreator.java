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
        Item newItem = this.loadItem(file, type);
        return newItem;
    }
    
    private Item loadItem(DataInputStream file, String type) throws IOException, WrongTypeException {
        String itemName = file.readUTF();
        ItemRarity rarity = ItemRarity.valueOf(file.readUTF());
        int goldValue = file.readInt();
        int armor = file.readInt();
        int damage = file.readInt();
        int health = file.readInt();
        int levelRequired = file.readInt();
        
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
    
    //String name, ItemRarity rarity, int damage, int bonusHealth, int armor, int levelRequired, int goldValue
    /*
     public void save(DataOutputStream file) throws IOException {
        file.writeUTF(super.getName());
        file.writeUTF(super.getRarity().toString());
        file.writeInt(this.goldValue);
        file.writeInt(this.bonusArmor);
        file.writeInt(this.bonusDamage);
        file.writeInt(this.bonusHealth);
        file.writeInt(this.levelRequired);
        
    }
    */
    
}
