/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.valuables;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.items.items.Item2;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;
import java.util.Random;


public class Goods extends Item2 {

    private int dropChance;
    private int goldValue;
    private final Random random;
    
    public Goods(String name, ItemRarity rarity) {
        super(name, rarity);
        this.random = new Random();
        this.nastavHodnoty();
        
    }
    
    public Goods() {
        this("Trash", ItemRarity.COMMON);
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

    @Override
    public int getDropChance() {
        return this.dropChance;
    }

    @Override
    public int getGoldValue() {
        return this.goldValue;
    }

    @Override
    public String toString() {
        return String.format("Goods{%s ,rarity=%s value= %d }", super.getName(), super.getRarity(),  this.goldValue);
    }
    
    
    
    
    
}