/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.BasicGui;
import gui.hero.listener.IUpdatePlayerListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.items.items.Equipment;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * Trieda sluzi na zobrazenie informacii o predmete
 */
public class ItemDetailsPanel extends JPanel {

    private ArrayList<JButton> buttons;
    private JButton unequipButton;
    private JButton equipButton;
    private JButton sellButton;
    private final DetailLabelHolder labelsManager;
    private final Player player;
    private Item currentItem;
    private IUpdatePlayerListener listener;
    
    /**
     * Vytvori instanciu
     * @param player 
     */
    public ItemDetailsPanel(Player player) {
        this.currentItem = null;
        this.player = player;
        this.buttons = new ArrayList<JButton>();
        this.setupButtons();
        this.labelsManager = new DetailLabelHolder();
        
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        
        this.setBackground(Color.white);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(this.unequipButton);
        buttonsPanel.add(this.equipButton);
        buttonsPanel.add(this.sellButton);
        buttonsPanel.setBackground(Color.black);
        
        this.add(buttonsPanel, BorderLayout.NORTH);
     
        JPanel separatorPanel = new JPanel();
        
        separatorPanel.setBackground(Color.lightGray);
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
        this.labelsManager.updateText("Name", item.getName());
        this.labelsManager.updateText("Rarity", item.getRarity().toString());
        this.labelsManager.updateText("Value", item.getGoldValue());
        if (item instanceof Equipment) {
            Equipment equipment = (Equipment)item;
            int damage = 0;
            int armor = 0;
            int health = 0;
            damage = equipment.getBonusDamage();
            armor = equipment.getBonusArmor();
            health = equipment.getBonusHealth();
            this.labelsManager.updateText("Damage", damage);
            this.labelsManager.updateText("Armor", armor);
            this.labelsManager.updateText("Health", health);
            
            this.labelsManager.showLabel("Damage");
            this.labelsManager.showLabel("Armor");
            this.labelsManager.showLabel("Health");
        
        } else {
            this.labelsManager.hideLabel("Damage");
            this.labelsManager.hideLabel("Armor");
            this.labelsManager.hideLabel("Health");
        }
        
        
        this.setEnabledAll(shouldBeEquippable);
        
    }
    
    private void setEnabledAll(boolean enabled) {
        for (JButton button : this.buttons) {
            button.setEnabled(enabled);
        }
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
        
        
    }
    
    /**
     * Vytvori a nastavi tlacidla
     */
    private void setupButtons() {
        this.equipButton = new JButton("Equip");
        this.unequipButton = new JButton("Remove");
        this.sellButton = new JButton("Sell");
        
        this.buttons.add(this.unequipButton);
        this.buttons.add(this.equipButton);
        this.buttons.add(this.sellButton);
        
        this.equipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetailsPanel.this.equipItem();
            }
        });
        
        this.unequipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetailsPanel.this.removeItem();
            }
        });
        
        this.sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetailsPanel.this.sellItem();
            }
        });
        
        for (JButton button : this.buttons) {
            button.setFont(BasicGui.getFont());
            button.setBackground(Color.white);
            button.setFocusable(false);
        }
        
    }
    
    private void callListener() {
        if (this.listener != null) {
            this.listener.update();
        }
    }
    
    private void clearInfo() {
        this.labelsManager.updateText("Name", "None");
        this.labelsManager.updateText("Rarity", "None");
        this.labelsManager.updateText("Value", 0);
        
        this.labelsManager.updateText("Damage", 0);
        this.labelsManager.updateText("Armor", 0);
        this.labelsManager.updateText("Damage", 0);
    }
    
    /**
     * Da si item na seba
     */
    private void equipItem() {
        this.player.getSlots().equip(this.currentItem);
        this.clearInfo();
        this.callListener();
    }
    
    /**
     * Vymaze item
     */
    private void removeItem() {
        this.player.getInventory().removeItem(this.currentItem);
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
        this.removeItem();
        
    }
}
