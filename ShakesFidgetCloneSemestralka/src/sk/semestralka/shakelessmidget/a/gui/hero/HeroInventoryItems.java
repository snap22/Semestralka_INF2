
package sk.semestralka.shakelessmidget.a.gui.hero;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.creatures.Player;
import sk.semestralka.shakelessmidget.a.gui.listeners.IShowItemListener;

/**
 * Trieda HeroInventoryItems sluzi na zobrazenie itemov hraca v inventari
 */
public class HeroInventoryItems {
    private final Player player;
    private final ArrayList<Item> items;
    private final DefaultListModel listModel;
    private JList list;
    
    private IShowItemListener listener;
    /**
     * Konstruktor. Nastavi pociatocne hodnoty
     * @param player 
     */
    public HeroInventoryItems(Player player) {
        this.list = new JList();
        this.player = player;
        this.items = new ArrayList<Item>();
        this.listModel = new DefaultListModel();
        this.list.setModel(this.listModel);
        this.update();
        this.list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        this.getPlayerItems();
        this.list.setVisibleRowCount(8);
        
        
        this.list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    if (HeroInventoryItems.this.list.getSelectedIndex() != -1) {     //osetruje ak by bol selectnuty predmet a prepne sa panel
                        if (HeroInventoryItems.this.listener != null) {
                            HeroInventoryItems.this.listener.itemSelected(HeroInventoryItems.this.items.get(HeroInventoryItems.this.list.getSelectedIndex()));
                            HeroInventoryItems.this.list.clearSelection();
                        }
                    }
                    
                    
                } 
            }
        });
    }
    
    /**
     * Nastavi posluchaca
     * @param listener 
     */
    public void setListener(IShowItemListener listener) {
        if (listener == null) {
            return;
        }
        this.listener = listener;
    }
    

    /**
     * Metoda sluzi na pridanie predmetov do zoznamu
     */
    public void update() {

        this.clear();
        
        this.getPlayerItems();
        
        for (int item = 0; item < this.items.size(); item++) {
            this.listModel.add(item, this.items.get(item).getName());
            
        }
        
        this.list.updateUI();
        
    }
    
    /**
     * Ziska predmety od hraca
     */
    protected void getPlayerItems() {
        Inventory playerInventory = this.player.getInventory();
        for (int i = 0; i < playerInventory.getCurrentSize(); i++) {
            this.addItem(playerInventory.getItem(i));
        }
    }
    
    /**
     * Vymaze predmety
     */
    private void clear() {
        this.listModel.removeAllElements();
        this.items.clear();
    }
    
    /**
     * Prida predmet
     * @param item 
     */
    protected void addItem(Item item) {
        if (item == null) {
            return;
        }
        
        this.items.add(item);
        
    }
    
    /**
     * Vrati hraca
     * @return 
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Vrati list
     * @return 
     */
    public JList getList() {
        return this.list;
    }
    
    
    
    
    
}
