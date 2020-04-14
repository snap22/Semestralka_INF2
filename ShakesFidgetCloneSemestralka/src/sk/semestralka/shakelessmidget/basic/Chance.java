/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.basic;

import java.util.Random;

/**
   Trieda na generovanie nahodnej sance
*/
public abstract class Chance {
    
    /**
     * Metoda pre vygenerovanie udalosti s danou percentualnou sancou
     * @param percentage aka ma byt sanca pre danu udalost
     * @return vrati hodnotu boolean, ci udalost nastala alebo nie
     */
    public static boolean generate(int percentage) {
        if (percentage >= 100) {
            return true;
        } 
        if (percentage <= 0) {
            return false;
        }
        
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        return randomNumber < percentage;
    }
    
    /**
     * Vrati nahodne cislo v danom rozmedzi, mozu byt iba nezaporne cisla
     * @param min minimalna hodnota (inclusive)
     * @param max maximalna hodnota (inclusive)
     * @return 
     */
    public static int random(int min, int max) {
        if (min >= max) {
            return max; 
        }
        
        if (min < 0 || max < 0) {
            return 0; 
        }
        
        
        Random random = new Random();
        return (random.nextInt((max - min) + 1) + min);
    }
}
