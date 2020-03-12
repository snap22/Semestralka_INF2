/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.characteristics;

import creatures.Player;

/**
 *
 * @author marce
 */
public interface ICharacteristic {
    void doSpecialStuff(Player player);
    int gainBonusDamage();
    void upgrade();
    String getPopis();
}
