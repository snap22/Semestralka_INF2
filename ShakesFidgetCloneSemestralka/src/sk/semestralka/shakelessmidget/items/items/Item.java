/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.items;

/**
 * Trieda Item reprezentuje predmety. Kazdy predmet ma svoje meno, penaznu hodnotu a svoju vzacnost
 * @author marce
 */
public abstract class Item {
    
    private ItemRarity rarity;
    private String name;

    /**
     * Konstruktor, vytvori instanciu s danymi hodnotami
     * @param name meno
     * @param rarity  vzacnost
     */
    public Item(String name, ItemRarity rarity) {
        this.name = name;
        this.rarity = rarity;  
    }


    /**
     * Vrati meno
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    public abstract int getGoldValue();


    /**
     * Podla rarity vrati percentualnu sancu na drop
     * @return 
     */
    public int getDropChance() {
        switch (this.rarity) {
            case COMMON:
                return 75;
            case UNCOMMON:
                return 40;
            case RARE:
                return 20;
            case EPIC:
                return 10;
            default:
                return 0;
            
        }
    }

    /**
     * Vrati vzacnost predmetu
     * @return 
     */
    public ItemRarity getRarity() {
        return this.rarity;
    }

}
