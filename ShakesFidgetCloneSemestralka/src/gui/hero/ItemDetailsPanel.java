/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.BasicGui;
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
 * @author marce
 */
public class ItemDetailsPanel extends JPanel {

    private ArrayList<JButton> buttons;
    private JButton removeButton;
    private JButton equipButton;
    private JButton sellButton;
    private final DetailLabelHolder labelsManager;
    private final Player player;
    private Item currentItem;
    
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
        buttonsPanel.add(this.removeButton);
        buttonsPanel.add(this.equipButton);
        buttonsPanel.add(this.sellButton);
        buttonsPanel.setBackground(Color.black);
        
        this.add(buttonsPanel, BorderLayout.NORTH);
     
        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.black);
        separatorPanel.setPreferredSize(new Dimension(80, 100));
        this.add(separatorPanel, BorderLayout.WEST);
        
        
        this.setupLabels();
        
        this.add(this.labelsManager, BorderLayout.CENTER);
        
    }
    
    /**
     * Aktualizuje informacie ohladom vybraneho predmetu
     * @param item 
     */
    public void showInfo(Item item) {
        this.currentItem = item;
        this.labelsManager.updateText("Name", item.getName());
        this.labelsManager.updateText("Rarity", item.getRarity().toString());
        this.labelsManager.updateText("Value", item.getGoldValue());
        
        int damage = 0;
        int armor = 0;
        int health = 0;
        if (item instanceof Equipment) {
            Equipment equipment = (Equipment)item;
            damage = equipment.getBonusDamage();
            armor = equipment.getBonusArmor();
            health = equipment.getBonusHealth();
        }
        
        this.labelsManager.updateText("Damage", damage);
        this.labelsManager.updateText("Armor", armor);
        this.labelsManager.updateText("Damage", health);
    }
    
    private void setupLabels() {
        this.labelsManager.addLabel("Name", "None");
        this.labelsManager.addLabel("Rarity", "None");
        this.labelsManager.addLabel("Value", 0);
        this.labelsManager.addLabel("Damage", 0);
        this.labelsManager.addLabel("Armor", 0);
        this.labelsManager.addLabel("Health", 0);
        
        
    }
    
    private void setupButtons() {
        this.equipButton = new JButton("Equip");
        this.removeButton = new JButton("Remove");
        this.sellButton = new JButton("Sell");
        
        this.buttons.add(this.removeButton);
        this.buttons.add(this.equipButton);
        this.buttons.add(this.sellButton);
        
        this.equipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetailsPanel.this.equipItem();
            }
        });
        
        this.removeButton.addActionListener(new ActionListener() {
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
    
    private void equipItem() {
        this.player.getSlots().equip(this.currentItem);
    }
    
    private void removeItem() {
        this.player.getInventory().removeItem(this.currentItem);
    }
    
    private void sellItem() {
        if (this.currentItem == null) {
            return;
        }
        this.player.addGold(this.currentItem.getGoldValue());
        this.player.getInventory().removeItem(this.currentItem);
    }
}
