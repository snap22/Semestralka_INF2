/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.basic;

import sk.semestralka.shakelessmidget.basic.Chance;


public class Constitution extends Stat {

    public Constitution(int amount) {
        super(amount);
    }

    public Constitution() {
        super();
    }

    @Override
    public void change(PlayerAttributes attributes) {
        attributes.changeHealth(this.getAmount());
    }
    
}
