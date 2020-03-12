/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import creatures.Creature;
import creatures.Imp;
import creatures.Player;
import creatures.specialCharacters.KamikazeeGuy;


/**
 *
 * @author marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creature imp = new Imp("Imp", 20, 10);
        
        Creature player = new Player(10, 10, new KamikazeeGuy());
        player.attack(imp);
        
        
    }
    
}


