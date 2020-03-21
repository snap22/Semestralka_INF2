/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import items.equippable.Armor;
import items.equippable.Helmet;
import items.equippable.Weapon;
import items.valuables.Goods;
import java.util.Random;

/**
 * Trieda ma za ulohu to, aby vytvorila nahodne itemy
 */
public abstract class ItemGenerator {
    
    private enum Type { WEAPON, HELMET, ARMOR, GOODS };
    
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
     * Vygeneruje item podla zadaneho typu
     * @param type typ ktory chceme vytvorit
     * @return 
     */
    private static Item2 generate(Type type) {
        String itemName = getAdjective();
        ItemRarity rarity = ItemRarity.getRandom();
        int levelRequired = getRandomLevelRequirement();
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
     * Vrati nahodne pridavne meno pre vec
     * @return 
     */
    private static String getAdjective() {
        String[] adjectives = {"Iron ", "Golden ", "Wooden ", "Elemental ", "Magical ", "Overpowered ", "Majestic ", "Astonishing ", 
            "Stone ", "Brutal ", "Bloody ", "Savage ", "Empowered ", "Shining ", "Diamond ", "Gladiator ", "Training "};
        return getRandom(adjectives);
    }
    
    /**
     * Vrati nahodne meno pre zbran
     * @return 
     */
    private static String getWeaponName() {
        String[] weaponNames = {"Sword", "Axe", "Machette", "Mace", "Hammer", "Spear", "Dagger"};
        return getRandom(weaponNames);
    }

    /**
     * Vytvori nahodne meno pre Goods
     * @return 
     */
    private static String getGoodsName() {
        String[] names = {"Trash", "Pile of trash", "Bone", "Cup", "Broom", "Spoon"};
        return getRandom(names);
    }
    
    /**
     * Vrati nahodny string zo zadanych moznosti
     * @param values
     * @return 
     */
    private static String getRandom(String[] values) {
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }
    
    /**
     * Nahodne vrati potrebny level od 1 do 60
     * @return 
     */
    private static int getRandomLevelRequirement() {
        Random random = new Random();
        return random.nextInt(60) + 1;
    }
    
    
}
