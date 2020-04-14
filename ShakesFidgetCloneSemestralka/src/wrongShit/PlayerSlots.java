/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrongShit;


import semestralka.game.player.basic.Player;
import semestralka.game.player.moods.Mood;
import wrongShit.EquippableItem;
import wrongShit.ItemType;
import wrongShit.Slot;

/**
 * Trieda ma za ulohu starat sa o equipovanie itemov, unequipovanie itemov, zabezpecit pridanie statov hracovi.
 * 
 */
public class PlayerSlots {
    private Slot headSlot;
    private Slot armorSlot;
    private Slot weaponSlot;
    private Slot[] slots;
    
    private final Player player;

    public PlayerSlots(Player player) {
        this.player = player;
        this.headSlot = new Slot(ItemType.HELMET);
        this.armorSlot = new Slot(ItemType.ARMOR);
        this.weaponSlot = new Slot(ItemType.WEAPON);
        this.slots = new Slot[]{this.headSlot, this.armorSlot, this.weaponSlot};
    }
    
    /**
     * Najde prvy slot do ktoreho moze vlozit dany item a equipnut ho
     * @param item 
     */
    public void equip(EquippableItem item) {
        for (Slot slot : this.slots) {
            //pokusi sa dat do slotu dany item, vrati boolean ci sa mu to podarilo + nastavi item na equipped
            if (slot.canInsert(item)) { 
                slot.insertItem(item);
                //this.player.increaseStats(item);
                System.out.println("Uspesne equipnuty predmet");
                return;
            }
        }
    }
    
    /**
     * Pretazenie metody equip, vlozi naladu do hraca
     * @param mood nalada ktoru chceme zmenit
     */
    public void equip(Mood mood) {
        this.player.changeMood(mood);
    }
    
    /**
     * Vymaze item na danej pozicii 
     * @param index index slotu z ktoreho ma vymazat item
     */
    public void remove(int index) {
        if (index >= this.slots.length || index < 0) {
            return;
        }
        
        this.slots[index].removeItem();
    }
    
}
