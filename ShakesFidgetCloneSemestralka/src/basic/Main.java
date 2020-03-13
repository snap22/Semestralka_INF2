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
import creatures.Player;
import player.characteristics.Suicidal;


/**
 *
 * @author marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Enemy imp = new Imp();
        
        Creature player = new Player(10, 10, null);
        Objective obj = new Objective("Imp", "Zabi", imp, 20, 5, 1);
        Mission mission = new Mission(obj, (Player)player);
        mission.start();
        
        
        
    }
    
}


