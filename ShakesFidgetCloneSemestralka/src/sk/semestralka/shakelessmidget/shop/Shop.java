/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.shop;

import sk.semestralka.shakelessmidget.generators.ItemGenerator;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class Shop {

    private final Player player;
    private final ItemGenerator itemGen;

    public Shop(Player player) {
        this.player = player;
        this.itemGen = new ItemGenerator();   
    }
    
    /**
     * Metoda ktora sluzi na to aby si hrac mohol kupit nahodny predmet za peniaze
     */
    public void buyItem() {
        //Sem tad try catch pre "Nemas dostatok penazi"
        Item item = this.itemGen.generateRandomItem(this.player.getLevel());
        this.player.addItem(item);
        
    }
    
    /**
     * Metoda ktora sluzi na to aby zmenila hracovi naladu za peniaze
     */
    public void switchMood() {
        //Sem tad try catch pre "Nemas dostatok penazi"
        //spravit moodgenerator :D
    }
    
    public void sellItem(Item item) {
        //sem dat try catch pre "Nie je taky item v inventory"
        this.player.getInventory().removeItem(item);
    }
    
}
