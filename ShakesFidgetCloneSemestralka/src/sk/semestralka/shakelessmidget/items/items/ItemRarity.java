/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.items;

import java.util.Random;

/**
 * Vzacnost itemov. Podla vzacnosti sa meni sanca  na drop
 * 
 */
public enum ItemRarity {
    COMMON, UNCOMMON, RARE, EPIC;
    
    /**
     * Vrati hodnotu na zaklade vlozeneho indexu
     * @param index
     * @return 
     */
    public static ItemRarity getRarity(int index) {
        if (index >= values().length || index < 0) {
            return COMMON;
        }
        return values()[index];
    }
    
    /**
     * Vrati nahodnu hodnotu
     * @return 
     */
    public static ItemRarity getRandom() {
        Random random = new Random();
        return getRarity(random.nextInt(values().length));
    }
}
