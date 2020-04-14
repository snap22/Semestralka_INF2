/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.generators;

import sk.semestralka.shakelessmidget.generators.ExampleType;
import sk.semestralka.shakelessmidget.generators.LoadFile;
import sk.semestralka.shakelessmidget.items.items.Item2;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.valuables.Goods;
import java.util.Random;

/**
 * Trieda ma za ulohu to, aby vytvorila nahodne itemy
 */
public abstract class ItemGenerator {

    private enum Type { WEAPON, HELMET, ARMOR, GOODS };
    
    
    /**
     * Vrati nahodne vytvorenu zbran podla zadaneho levelu
     * @param level
     * @return 
     */
    public static Weapon generateWeapon(int level) {
        return (Weapon)generate(Type.WEAPON, level);
    }

    /**
     * Vytvori nahodne vytvoreny armor podla zadaneho levelu
     * @param level
     * @return 
     */
    public static Armor generateArmor(int level) {
        return (Armor)generate(Type.ARMOR, level);
    }

    /**
     * Vrati nahodne vytvorenu helmu podla zadaneho levelu
     * @param level
     * @return 
     */
    public static Helmet generateHelmet(int level) {
        return (Helmet)generate(Type.HELMET, level);
    }
    
    
    
    /**
     * Vrati nahodne vytvorenu zbran
     * @return 
     */
    public static Weapon generateWeapon() {
        return (Weapon)generate(Type.WEAPON);
    }
    
    /**
     * Vrati nahodne vytvorenu helmu
     * @return 
     */
    public static Helmet generateHelmet() {
        return (Helmet)generate(Type.HELMET);
    }
    
    /**
     * Vrati nahodne vytvoreny armor
     * @return 
     */
    public static Armor generateArmor() {
        return (Armor)generate(Type.ARMOR);
    }
    
    /**
     * Vrati nahodne vytvoreny goods
     * @return 
     */
    public static Goods generateGoods() {
        return (Goods)generate(Type.GOODS);
    }
    
    /**
     * Vrati nahodne vytvoreny item
     * @return 
     */
    public static Item2 generateRandomItem() {
        int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                return generateWeapon();
            case 1:
                return generateArmor();
            case 2:
                return generateHelmet();
            default:
                return generateGoods();
        }
    }
    
    /**
     * Vrati nahodny item podla zadaneho levelu
     * @param level
     * @return 
     */
    public static Item2 generateRandomItem(int level) {
        int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                return generateWeapon(level);
            case 1:
                return generateArmor(level);
            case 2:
                return generateHelmet(level);
            default:
                return generateGoods();
        }
    }
    
    /**
     * Vygeneruje item podla zadaneho typu a levelu
     * @param type typ ktory chceme vytvorit
     * @return 
     */
    private static Item2 generate(Type type, int levelRequired) {
        if (levelRequired <= 0) {
            levelRequired = 1;
        }
        
        String itemName = getAdjective();
        ItemRarity rarity = ItemRarity.getRandom();
        switch (type) {
            case WEAPON:
                itemName += getWeaponName();
                return new Weapon(itemName, rarity, levelRequired);
            case HELMET:
                itemName += "Helmet";
                return new Helmet(itemName, rarity, levelRequired);
            case ARMOR:
                itemName += "Armor";
                return new Armor(itemName, rarity, levelRequired);
            case GOODS:
                itemName = getGoodsName();
                return new Goods(itemName, rarity);
            default:
                return null;
        }
        
    }
    
    /**
     * Vygeneruje nahodny item podla zadaneho typu
     * @param type
     * @return 
     */
    private static Item2 generate(Type type) {
        int levelRequired = getRandomLevelRequirement();
        return generate(type, levelRequired);
    }

    /**
     * Vrati nahodne pridavne meno pre vec
     * @return 
     */
    private static String getAdjective() {
        LoadFile lf = new LoadFile(ExampleType.ITEMSADJECTIVE);
        return lf.getRandom();
    }
    
    /**
     * Vrati nahodne meno pre zbran
     * @return 
     */
    private static String getWeaponName() {
        LoadFile lf = new LoadFile(ExampleType.WEAPONNAME);
        return lf.getRandom();
    }

    /**
     * Vytvori nahodne meno pre Goods
     * @return 
     */
    private static String getGoodsName() {
        LoadFile lf = new LoadFile(ExampleType.GOODSNAME);
        return lf.getRandom();
    }
    
    /**
     * Vrati nahodny string zo zadanych moznosti
     * @param values
     * @return 
     */
    
    /**
     * Nahodne vrati potrebny level od 1 do 60
     * @return 
     */
    private static int getRandomLevelRequirement() {
        Random random = new Random();
        return random.nextInt(60) + 1;
    }
    
    
}
