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
public class ItemLoader {

    /**
     * Vytvori instanciu
     */
    public ItemLoader() {
    }
    
    /**
     * Nacita zo suboru predmet a vytvori ho
     * @param file subor
     * @return
     * @throws IOException
     * @throws WrongTypeException 
     */
    public Item createItem(DataInputStream file) throws IOException, WrongTypeException {
        String type = file.readUTF().toLowerCase();
        Item newItem;
        if (type.equals("goods")) {
            newItem = this.loadGoods(file);
        } else {
            newItem = this.loadEquipment(file, type);
        }
        return newItem;
    }
    
    
    /**
     * Vrati predmet typu Equipment
     * @param file subor
     * @param type typ
     * @return
     * @throws IOException
     * @throws WrongTypeException 
     */
    private Item loadEquipment(DataInputStream file, String type) throws IOException, WrongTypeException {
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
            default:
                throw new WrongTypeException();
        }
    }
    
    /**
     * Vrati predmet typu Goods
     * @param file subor
     * @return
     * @throws IOException 
     */
    private Goods loadGoods(DataInputStream file) throws IOException {
        String itemName = file.readUTF();
        ItemRarity rarity = ItemRarity.valueOf(file.readUTF());
        int goldValue = file.readInt();
        return new Goods(itemName, rarity, goldValue);
    }
    
    
    
   
    
}
