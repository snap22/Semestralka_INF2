
package sk.semestralka.shakelessmidget.items.slots;


import sk.semestralka.shakelessmidget.exceptions.WrongItemTypeException;
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

        Slot slot;
        try {
            slot = this.getSlot(item);
            this.equipItem(slot, (Equipment)item);
        } catch (WrongItemTypeException ex) {
            throw new NotEquippableException();
        }
        
        
    }
    
    public void unequip(Item item) throws InventoryFullException, NotEquippableException {

        Slot slot;
        try {
            slot = this.getSlot(item);
            this.unequipSlot(slot);
        } catch (WrongItemTypeException ex) {
            throw new NotEquippableException();
        }
        
    }
    
    private Slot getSlot(Item item) throws WrongItemTypeException {
        if (item instanceof Helmet) {
            return this.headSlot;
            
        } else if (item instanceof Armor) {
            return this.armorSlot;
            
        } else if (item instanceof Weapon) {
            return this.weaponSlot;
            
        } else {
            throw new WrongItemTypeException();
        }
    }
    
    /**
     * Dá na seba helmu
     * @param item 
     * @throws InventoryFullException
     * @throws LowLevelException
     */
    public void equip(Helmet item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.headSlot, item);
    }
    
    /**
     * Dá na seba armor
     * @param item 
     * @throws InventoryFullException
     * @throws LowLevelException
     */
    public void equip(Armor item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.armorSlot, item);
    }
    
    /**
     * Dá na seba zbraň
     * @param item 
     * @throws InventoryFullException 
     * @throws LowLevelException
     */
    public void equip(Weapon item) throws InventoryFullException, LowLevelException {
        this.equipItem(this.weaponSlot, item);
    }
    
    //      ******    Getters   *******
    
    /**
     * Vrati slot na zbran
     * @return 
     */
    public Slot<Weapon> getWeaponSlot() {
        return this.weaponSlot;
    }

    /**
     * Vrati slot na armor
     * @return 
     */
    public Slot<Armor> getArmorSlot() {
        return this.armorSlot;
    }

    /**
     * Vrati slot na prilbu
     * @return 
     */
    public Slot<Helmet> getHeadSlot() {
        return this.headSlot;
    }
    
    
     /**
     * Vymaze item z daneho slotu a da ho do inventory hraca
     * @param index
     * @return 
     */
    private void unequipSlot(Slot slot) throws InventoryFullException {
        Equipment item = null;
        if (this.inventory.isFull()) {
            throw new InventoryFullException();     //aby najprv vyhodilo vynimku a nevymazalo ziadny predmet
        }
        
        item = (Equipment)slot.remove();
        
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
