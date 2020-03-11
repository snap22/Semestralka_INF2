/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures.specialCharacters;

import creatures.Player;
import java.util.Random;


public class KamikazeeGuy implements ICharacter {

    @Override
    public void doSpecialStuff(Player player) {
        Random random = new Random();
        if (random.nextBoolean()) {
            player.die();
        }
        
    }
    
}
