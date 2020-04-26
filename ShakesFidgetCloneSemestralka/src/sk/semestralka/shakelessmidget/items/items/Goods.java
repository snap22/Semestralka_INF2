/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.items;

import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;
import java.util.Random;

/**
 * Trieda Goods sluzi ako nepouzitelny predmet pre hraca
 * @author marce
 */
public class Goods extends Item {

    private int dropChance;
    private int goldValue;
    private final Random random;
    
    /**
     * Konstruktor, vytvori instanciu
     * @param name meno
     * @param rarity  vzacnost
     */
    public Goods(String name, ItemRarity rarity) {
        super(name, rarity);
        this.random = new Random();
        this.nastavHodnoty();
        
    }
    
    /**
     * Testovaci konstruktor
     */
    public Goods() {
        this("Trash", ItemRarity.COMMON);
    }
    
        /**
     * Vrati vlastnu hodnotu sance na drop
     * @return 
     */
    @Override
    public int getDropChance() {
        return this.dropChance;
    }

    /**
     * Vrati vlastnu hodnotu v goldoch
     * @return 
     */
    @Override
    public int getGoldValue() {
        return this.goldValue;
    }

    /**
     * Vrati triedu v podobe stringu
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Goods{%s ,rarity=%s value= %d }", super.getName(), super.getRarity(),  this.goldValue);
    }
    
    /**
     * Ulozi hodnoty do suboru
     * @param file
     * @throws IOException 
     */
    @Override
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF("goods");
        file.writeUTF(super.getName());
        file.writeUTF(super.getRarity().toString());
        file.writeInt(this.goldValue);
    }
    
    
    /**
     * Meni hodnotu sance na drop a ceny v goldoch podla toho aka je vzacnost
     */
    private void nastavHodnoty() {
        switch (super.getRarity()) {
            case COMMON:
                this.dropChance = 100;
                this.goldValue = Chance.random(1, 5);
                //this.goldValue = this.random.nextInt(5) + 1;       // 1 - 5
                break;
            case UNCOMMON:
                this.dropChance = 50;
                this.goldValue = Chance.random(10, 20);
                //this.goldValue = this.random.nextInt(10) + 10;      // 10 - 20
                break;
            case RARE:
                this.dropChance = 25;
                this.goldValue = Chance.random(50, 100);
                //this.goldValue = this.random.nextInt(50) + 50;    // 50 - 100
                break;
            case EPIC:
                this.dropChance = 10;
                this.goldValue = Chance.random(150, 500);
                //this.goldValue = this.random.nextInt(150) + 100;    // 100 - 250
                break;
            default:
                this.dropChance = 0;
                this.goldValue = 0;
        }
    }


}
