/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.items.slots;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.LowLevelException;
import sk.semestralka.shakelessmidget.exceptions.NotEquippableException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import sk.semestralka.shakelessmidget.loaders.ItemLoader;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.items.Equipment;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda zodpoveda za to aby si hrac mohol dať na seba (equipnut) a zo seba rozne predmety a zabezpecuje aby sa vratili do inventory
 */
public class PlayerSlots {
    private ArrayList<Item> currentItemsEquipped;
    private Slot<Weapon> weaponSlot;
    private Slot<Armor> armorSlot;
    private Slot<Helmet> headSlot;
    private final Player player;
    private Inventory inventory;
    
    /**
     * Konstruktor, vytvori instanciu
     * @param player hrac ktoreho equipnute itemy bude spravovat
     */
    public PlayerSlots(Player player) {
        this.currentItemsEquipped = new ArrayList<Item>();
        this.weaponSlot = new Slot<Weapon>();
        this.armorSlot = new Slot<Armor>();
        this.headSlot = new Slot<Helmet>();
        
        this.player = player;
        this.inventory = this.player.getInventory();
        
        
    }
    
    /**
     * Pozrie sa kde pasuje dany predmet a ak sa da tak ho da na seba
     * @param item predmet
     * @throws InventoryFullException
     * @throws LowLevelException
     * @throws NotEquippableException
     */
    public void equip(Item item) throws InventoryFullException, LowLevelException, NotEquippableException {
        if (item instanceof Helmet) {
            this.equip((Helmet)item);
            
        } else if (item instanceof Armor) {
            this.equip((Armor)item);
            
        } else if (item instanceof Weapon) {
            this.equip((Weapon)item);
            
        } else {
            throw new NotEquippableException();
        }
        
    }
    
    public void unequip(Item item) throws InventoryFullException {
        if (item instanceof Helmet) {
            this.unequipHelmet();
            
        } else if (item instanceof Armor) {
            this.unequipArmor();
            
        } else if (item instanceof Weapon) {
            this.unequipWeapon();
            
        } else {
            System.out.println("How did this happen?");
        }
    }
    
    /**
     * Dá na seba helmu
     * @param item 
     * @throws InventoryFullException
     */
    public void equip(Helmet item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.headSlot, item);
    }
    
    /**
     * Dá na seba armor
     * @param item 
     * @throws InventoryFullException
     */
    public void equip(Armor item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.armorSlot, item);
    }
    
    /**
     * Dá na seba zbraň
     * @param item 
     * @throws InventoryFullException 
     */
    public void equip(Weapon item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.weaponSlot, item);
    }
    

    /**
     * Dá dole zo seba zbraň
     * @throws InventoryFullException
     */
    public void unequipWeapon() throws InventoryFullException {
        this.unequipAtPosition(0);
    }
    
    /**
     * Dá dole zo seba armor
     * @throws InventoryFullException
     */
    public void unequipArmor() throws InventoryFullException {
        this.unequipAtPosition(1);
    }
    
    /**
     * Dá dole zo seba helmu
     * @throws InventoryFullException
     */
    public void unequipHelmet() throws InventoryFullException {
        this.unequipAtPosition(2);
    }
    
    /**
     * Dá dole zo seba vsetky veci
     * @throws InventoryFullException
     */
    public void unequipAll() throws InventoryFullException {
        this.unequipWeapon();
        this.unequipArmor();
        this.unequipHelmet();
    }
    
   
    
    //      ******    Getters   *******
    
    public Slot<Weapon> getWeaponSlot() {
        return this.weaponSlot;
    }

    public Slot<Armor> getArmorSlot() {
        return this.armorSlot;
    }

    public Slot<Helmet> getHeadSlot() {
        return this.headSlot;
    }
    
    
     /**
     * Podla danej pozicie vymaze item zo slotu, hodi ho do inventory a z hraca da dole staty
     * @param index
     * @return 
     */
    private void unequipAtPosition(int index) throws InventoryFullException {
        Equipment item = null;
        if (this.inventory.isFull()) {
            throw new InventoryFullException();     //aby najprv vyhodilo vynimku a nevymazalo ziadny predmet
        }
        switch (index) {
            case 0:
                item = this.weaponSlot.remove();
                break;
            case 1:
                item = this.armorSlot.remove();
                break;
            case 2:
                item = this.headSlot.remove();
                break;
            default:
                return;
        }
        this.inventory.addItem(item);
        
        this.player.decreaseStats(item);
        this.currentItemsEquipped.remove(item);
        
    }

    /**
    * Vyberie z inventory a da na hraca. Ak uz je na hracovi equipnuty predmet, tak ho najskor da dole a da do inventory
    * @return 
    */
    private void equipItem(Slot slot, Equipment item) throws InventoryFullException, LowLevelException {
        if (item.getLevelRequired() > this.player.getLevel()) {
            throw new LowLevelException();
        }
        
        Item removedItem = null;
        if (!slot.isEmpty()) {
            removedItem = slot.remove();
            this.player.decreaseStats((Equipment)removedItem);   
            this.currentItemsEquipped.remove(removedItem);
        }
        
        this.inventory.removeItem(item);
        this.player.increaseStats(item);
        slot.insert(item);
        
        this.inventory.addItem(removedItem); 
        this.currentItemsEquipped.add(item);
        
    }
    
    /**
     * Najprv da predmet do inventory a potom ho equipne
     * @param item predmet
     */
    private void equipAfterLoad(Item item) {
        try {
            this.inventory.addItem(item);
            this.equip(item);
        } catch (InventoryFullException ex) {
            //nikdy sa to nestane lebo sa najprv nacitaju itemy ktore ma equipnute , teda inventory bude prazdny
        } catch (LowLevelException ex) {
            //nikdy sa to nestane lebo ak uz bol item equipnuty pred saveom tak urcite bude moct byt equipnuty aj pri loade
        } catch (NotEquippableException ex) {
            //tiez sa to nikdy nestane...
        }
        
            
        
    }

    /**
     * Nacita jednotlive predmety a da ich do slotov
     * @param file subor
     * @throws IOException
     * @throws WrongTypeException 
     */
    public void load(DataInputStream file) throws IOException, WrongTypeException {
        ItemLoader itemCreator = new ItemLoader();
        int numberOfItems = file.readInt();
        for (int i = 0; i < numberOfItems; i++) {
            Item newItem = itemCreator.createItem(file);
            this.equipAfterLoad(newItem);
        }
        
    }

    /**
     * Ulozi jednotlive predmety
     * @param file subor
     * @throws IOException 
     */
    public void save(DataOutputStream file) throws IOException {
        int numberOfItems = this.currentItemsEquipped.size();
        file.writeInt(numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            this.currentItemsEquipped.get(i).save(file);
            
        }
        
        //this.unequipAll();   // --> kvoli tomuto spadne program
        
    }
    
    
    
}
