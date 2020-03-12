/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

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
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        System.out.format("%d - %b %n", randomNumber, randomNumber < percentage);
        return randomNumber < percentage;
    }
}
