
package sk.semestralka.shakelessmidget.a.gui.hero;

import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import sk.semestralka.shakelessmidget.a.gui.listeners.IUpdatePlayerListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.LowLevelException;
import sk.semestralka.shakelessmidget.exceptions.NotEquippableException;
import sk.semestralka.shakelessmidget.items.items.Equipment;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 *
 * Trieda sluzi na zobrazenie informacii o predmete
 */
public class ItemDetailsPanel extends JPanel {

    private JButton equipButton;
    private JButton sellButton;
    private final DetailLabelHolder labelsManager;
    private final Player player;
    private Item currentItem;
    private IUpdatePlayerListener listener;
    private JButton unequipButton;
    
    /**
     * Vytvori instanciu
     * @param player 
     */
    public ItemDetailsPanel(Player player) {
        this.currentItem = null;
        this.player = player;
        this.setupButtons();
        this.labelsManager = new DetailLabelHolder();
        
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        
        this.setBackground(Color.white);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(this.equipButton);
        buttonsPanel.add(this.sellButton);
        buttonsPanel.add(this.unequipButton);
        buttonsPanel.setBackground(Color.darkGray);
        
        this.add(buttonsPanel, BorderLayout.NORTH);
     
        //na oddelenie
        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.white);
        separatorPanel.setPreferredSize(new Dimension(55, 100));
        this.add(separatorPanel, BorderLayout.WEST);
        
        
        this.setupLabels();
        
        this.add(this.labelsManager, BorderLayout.CENTER);
        
    }
    
    public void setListener(IUpdatePlayerListener listener) {
        if (listener == null) {
            return;
        }
        this.listener = listener;
    }
    
    /**
     * Aktualizuje informacie ohladom vybraneho predmetu
     * @param item 
     * @param shouldBeEquippable ci sa ma dat equipnut dany item
     */
    public void showInfo(Item item, boolean shouldBeEquippable) {
        this.currentItem = item;
        if (item == null) {
            return;
        }
        
        this.labelsManager.updateText("Name", item.getName());
        this.labelsManager.updateText("Rarity", item.getRarity().toString());
        this.labelsManager.updateText("Value", item.getGoldValue());
        
        if (item instanceof Equipment) {
            Equipment equipment = (Equipment)item;
            
            int damage = equipment.getBonusDamage();
            int armor = equipment.getBonusArmor();
            int health = equipment.getBonusHealth();
            int level = equipment.getLevelRequired();
            this.labelsManager.updateText("Damage", damage);
            this.labelsManager.updateText("Armor", armor);
            this.labelsManager.updateText("Health", health);
            this.labelsManager.updateText("Level", level);
            
            this.labelsManager.showLabel("Damage");
            this.labelsManager.showLabel("Armor");
            this.labelsManager.showLabel("Health");
            this.labelsManager.showLabel("Level");
        
        } else {
            this.labelsManager.hideLabel("Damage");
            this.labelsManager.hideLabel("Armor");
            this.labelsManager.hideLabel("Health");
            this.labelsManager.hideLabel("Level");
        }
        
        
        this.setEnabledAll(shouldBeEquippable);
        
    }
    
    /**
     * Nastavi pouzitelnost jednotlivych tlacidiel, unequip tlacidlo nastavi stale na opacne
     * @param enabled 
     */
    private void setEnabledAll(boolean enabled) {
        this.sellButton.setEnabled(enabled);
        this.equipButton.setEnabled(enabled);
        this.unequipButton.setEnabled(!enabled);
    }
    
    /**
     * Vytvori a nastavi pociatocne hodnoty itemu
     */
    private void setupLabels() {
        this.labelsManager.addLabel("Name", "None");
        this.labelsManager.addLabel("Rarity", "None");
        this.labelsManager.addLabel("Value", 0);
        this.labelsManager.addLabel("Damage", 0);
        this.labelsManager.addLabel("Armor", 0);
        this.labelsManager.addLabel("Health", 0);
        this.labelsManager.addLabel("Level", 0);
        
        
    }
    
    /**
     * Vytvori a nastavi tlacidla
     */
    private void setupButtons() {
        this.equipButton = new JButton("Equip");
        this.sellButton = new JButton("Sell");
        this.unequipButton = new JButton("Unequip");
        
        
        
        this.equipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ItemDetailsPanel.this.equipItem();
                } catch (InventoryFullException ex) {
                    ItemDetailsPanel.this.showInventoryFull();
                } catch (LowLevelException ex) {
                    JOptionPane.showMessageDialog(null, "Your level is not high enough", "Low level", JOptionPane.ERROR_MESSAGE);
                } catch (NotEquippableException ex) {
                    JOptionPane.showMessageDialog(null, "You cannot equip this item", "Wrong item", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        
        this.sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetailsPanel.this.sellItem();
            }
        });
        
        this.unequipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try {
                        ItemDetailsPanel.this.unequipItem();
                    } catch (NotEquippableException ex) {
                        JOptionPane.showMessageDialog(null, "You cannot unequip this item", "Wrong item", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InventoryFullException ex) {
                    ItemDetailsPanel.this.showInventoryFull();
                }
            }
        });
        
        this.adjustButton(this.sellButton);
        this.adjustButton(this.equipButton);
        this.adjustButton(this.unequipButton);
        
    }
    
    /**
     * Nastavi pociatocne hodnoty tlacidla
     * @param button 
     */
    private void adjustButton(JButton button) {
        button.setFont(BasicGui.getFont());
        button.setBackground(Color.white);
        button.setFocusable(false);
    }
    
    /**
     * Zavola posluchaca
     */
    private void callListener() {
        if (this.listener != null) {
            this.listener.update();
        }
    }
    
    /**
     * Vycisti labely
     */
    private void clearInfo() {
        this.labelsManager.updateText("Name", "None");
        this.labelsManager.updateText("Rarity", "None");
        this.labelsManager.updateText("Value", 0);
        
        this.labelsManager.updateText("Damage", 0);
        this.labelsManager.updateText("Armor", 0);
        this.labelsManager.updateText("Damage", 0);
        this.labelsManager.updateText("Level", 0);
        
        this.showInfo(null, false);
    }
    
    /**
     * Da si item na seba
     */
    private void equipItem() throws InventoryFullException, LowLevelException, NotEquippableException {
        this.player.getSlots().equip(this.currentItem);
        this.clearInfo();
        this.callListener();
    }
    
    /**
     * Da predmet dole zo seba
     * @throws InventoryFullException 
     */
    private void unequipItem() throws InventoryFullException, NotEquippableException {
        this.player.getSlots().unequip(this.currentItem);
        this.clearInfo();
        this.callListener();
    }
    
    
    /**
     * Preda item
     */
    private void sellItem() {
        if (this.currentItem == null) {
            return;
        }
        this.player.addGold(this.currentItem.getGoldValue());
        this.player.getInventory().removeItem(this.currentItem);
        this.clearInfo();
        this.callListener();
        
    }
    
    /**
     * Vrati okno ze inventory je plny
     */
    private void showInventoryFull() {
        JOptionPane.showMessageDialog(null, "Your inventory is full", "No space", JOptionPane.ERROR_MESSAGE);
    }
}
