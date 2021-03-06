
package sk.semestralka.shakelessmidget.generators;

import sk.semestralka.shakelessmidget.loaders.LoadFile;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.items.Goods;
import java.util.Random;

/**
 * Trieda ItemGenerator ma za ulohu to, aby vytvorila nahodne itemy
 */
public class ItemGenerator {

    private final LoadFile weapons;
    private final LoadFile itemsAdj;
    private final LoadFile goods;

    private enum Type { WEAPON, HELMET, ARMOR, GOODS };

    /**
     * Nastavi pociatocne hodnoty
     */
    public ItemGenerator() {
        this.weapons = new LoadFile(ExampleType.WEAPONNAME);
        this.itemsAdj = new LoadFile(ExampleType.ITEMSADJECTIVE);
        this.goods = new LoadFile(ExampleType.GOODSNAME);
    }
    
    
    /**
     * Vrati nahodne vytvorenu zbran podla zadaneho levelu
     * @param level level
     * @return zbran
     */
    public Weapon generateWeapon(int level) {
        return (Weapon)this.generate(Type.WEAPON, level);
        
    }

    /**
     * Vytvori nahodne vytvoreny armor podla zadaneho levelu
     * @param level level
     * @return armor
     */
    public Armor generateArmor(int level) {
        return (Armor)this.generate(Type.ARMOR, level);
    }

    /**
     * Vrati nahodne vytvorenu helmu podla zadaneho levelu
     * @param level level
     * @return helma
     */
    public Helmet generateHelmet(int level) {
        return (Helmet)this.generate(Type.HELMET, level);
    }
    
    
    
    /**
     * Vrati nahodne vytvorenu zbran
     * @return zbran
     */
    public Weapon generateWeapon() {
        return (Weapon)this.generate(Type.WEAPON);
    }
    
    /**
     * Vrati nahodne vytvorenu helmu
     * @return helma
     */
    public Helmet generateHelmet() {
        return (Helmet)this.generate(Type.HELMET);
    }
    
    /**
     * Vrati nahodne vytvoreny armor
     * @return armor
     */
    public Armor generateArmor() {
        return (Armor)this.generate(Type.ARMOR);
    }
    
    /**
     * Vrati nahodne vytvoreny goods
     * @return goods
     */
    public Goods generateGoods() {
        return (Goods)this.generate(Type.GOODS);
    }
    
    /**
     * Vrati nahodne vytvoreny item
     * @return nahodny predmet
     */
    public Item generateRandomItem() {
        int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                return this.generateWeapon();
            case 1:
                return this.generateArmor();
            case 2:
                return this.generateHelmet();
            default:
                return this.generateGoods();
        }
    }
    
    /**
     * Vrati nahodny item podla zadaneho levelu
     * @param level level
     * @return nahodny predmet
     */
    public Item generateRandomItem(int level) {
        int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                return this.generateWeapon(level);
            case 1:
                return this.generateArmor(level);
            case 2:
                return this.generateHelmet(level);
            default:
                return this.generateGoods();
        }
    }
    
    /**
     * Vygeneruje item podla zadaneho typu a levelu
     * @param type typ ktory chceme vytvorit
     * @return predmet
     */
    private Item generate(Type type, int levelRequired) {
        if (levelRequired <= 0) {
            levelRequired = 1;
        }
        
        String itemName = this.itemsAdj.getRandom();
        ItemRarity rarity = ItemRarity.getRandom();
        switch (type) {
            case WEAPON:
                itemName += this.weapons.getRandom();
                return new Weapon(itemName, rarity, levelRequired);
            case HELMET:
                itemName += " Helmet";
                return new Helmet(itemName, rarity, levelRequired);
            case ARMOR:
                itemName += " Armor";
                return new Armor(itemName, rarity, levelRequired);
            case GOODS:
                itemName = this.goods.getRandom();
                return new Goods(itemName, rarity);
            default:
                return null;
        }
        
    }
    
    /**
     * Vygeneruje nahodny item podla zadaneho typu
     * @param type
     * @return predmet
     */
    private Item generate(Type type) {
        int levelRequired = this.getRandomLevelRequirement();
        return this.generate(type, levelRequired);
    }

    /**
     * Vytvori nahodny level potrebny na equipnutie predmetu
     * @return nahodny level
     */
    private int getRandomLevelRequirement() {
        Random random = new Random();
        return random.nextInt(60) + 1;
    }
    
    
}
