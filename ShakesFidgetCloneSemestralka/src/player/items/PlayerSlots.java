/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;

import creatures.Player;

/**
 * Trieda ma za ulohu starat sa o equipovanie itemov, unequipovanie itemov, zabezpecit pridanie statov hracovi.
 * 
 */
public class PlayerSlots {
    private Slot headSlot;
    private Slot armorSlot;
    private Slot weaponSlot;
    
    private final Player player;

    public PlayerSlots(Player player) {
        this.player = player;
        this.headSlot = new Slot(ItemType.HELMET);
        this.armorSlot = new Slot(ItemType.ARMOR);
        this.weaponSlot = new Slot(ItemType.WEAPON);
    }
    
}
