/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import adventure.Mission;
import adventure.Objective;
import creatures.Creature;
import creatures.Enemy;
import creatures.Imp;
import items.equippable.Weapon;
import items.slots.Inventory;
import items.valuables.Goods;
import player.basic.Player;



/**
 *
 * @author marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Enemy imp = new Imp();
        
        Creature player = new Player(10, 10, null);
        Objective obj = new Objective("Imp", "Zabi", imp, 20, 5, 100, 1);
        Mission mission = new Mission(obj, (Player)player);
        mission.start();
        */
        
        Inventory inv = new Inventory();
        Weapon wep = new Weapon();
        Goods goodie = new Goods();
        inv.addItem(wep);
        
        
    }
    
}


