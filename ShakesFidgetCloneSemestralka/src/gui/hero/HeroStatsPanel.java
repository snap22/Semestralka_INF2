/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.BasicGui;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 * Trieda HeroStatsPanel sluzi pre zobrazovanie zakladnych informacii o hracovi
 */
public class HeroStatsPanel extends JPanel {
    
    private HashMap<String, DetailLabel> labels;
    private final Player player;
    private JProgressBar bar;
    private final HeroEquippedItems equippedItems;
    private final HeroInventoryItems inventoryItems;
    private final JLabel inventoryItemsLabel;
    private final DetailLabelHolder labelsManager;

    /**
     * Konstruktor pre triedu, vytvoria sa udaje ktore udavaju zakladne informacie o hracovi
     * @param player 
     */
    public HeroStatsPanel(Player player) {
        this.player = player;
        this.labelsManager = new DetailLabelHolder();
        this.bar = new JProgressBar(0, this.player.getRequiredXp());
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.labelsManager);
        
        this.labelsManager.addLabel("Mood", player.getMood().getName());
        this.labelsManager.addLabel("Health", player.getHealth());
        this.labelsManager.addLabel("Armor", player.getArmor());
        this.labelsManager.addLabel("Damage", player.getDamage());
        this.labelsManager.addLabel("Level", player.getLevel());
        this.labelsManager.addLabel("Gold", player.getGold());
        
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        
        this.add(this.bar);
        this.bar.setStringPainted(true);
        this.bar.setForeground(Color.orange);
        this.bar.setString("XP");
        
        
        
        
        this.add(Box.createRigidArea(new Dimension(5, 5)));
        this.add(new JSeparator());
        
        //  Equipped label
        JLabel equippedItemsLabel = new JLabel("Equipped:");
        equippedItemsLabel.setFont(BasicGui.getFont());
        this.add(equippedItemsLabel);
       
        
        //  Equipped items
        this.equippedItems = new HeroEquippedItems(this.player); 
        JScrollPane equippedScrollPane = new JScrollPane(this.equippedItems);
        this.add(equippedScrollPane);
        
        //  medzera
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        
        // Inventory Label
        this.inventoryItemsLabel = new JLabel("Inventory:");
        this.inventoryItemsLabel.setFont(BasicGui.getFont());
        this.add(this.inventoryItemsLabel);
        
        
        //  Inventory Items
        this.inventoryItems = new HeroInventoryItems(this.player);
        JScrollPane inventoryScrollPane = new JScrollPane(this.inventoryItems);
        this.add(inventoryScrollPane);

       
    }
    
    

    public HeroEquippedItems getEquippedItems() {
        return this.equippedItems;
    }

    public HeroInventoryItems getInventoryItems() {
        return this.inventoryItems;
    }
    
    
    
    /**
     * Aktualizuje vsetky komponenty
     */
    public void updateAll() {
        this.labelsManager.updateText("Mood", this.player.getMood().getName());
        this.labelsManager.getLabel("Mood").setToolTipText(this.player.getMood().getDescription());
        this.labelsManager.updateText("Health", this.player.getHealth());
        this.labelsManager.updateText("Armor", this.player.getArmor());
        this.labelsManager.updateText("Damage", this.player.getDamage());
        this.labelsManager.updateText("Level", this.player.getLevel());
        this.labelsManager.updateText("Gold", this.player.getGold());
        this.updateBar();
        this.equippedItems.update();
        this.inventoryItems.update();
        this.updateInventoryLabel();
        
    }
    
    private void updateInventoryLabel() {
        Inventory inv = this.player.getInventory();
        this.inventoryItemsLabel.setText(String.format("Inventory: %d / %d", inv.getCurrentSize(), inv.getMaxSize()));
    }
    
    private void updateBar() {
        this.bar.setMaximum(this.player.getRequiredXp());
        this.bar.setValue(this.player.getCurrentXp());
    }
    
    /**
     * Aktualizuje text v danom label-y
     * @param labelName
     * @param newText 
     */
    private void updateText(String labelName, String newText) {
        if (!this.labels.containsKey(labelName)) {
            return;
        }
        this.labels.get(labelName).setDescription(newText);
    }
    
    private void updateText(String labelName, int newText) {
        if (!this.labels.containsKey(labelName)) {
            return;
        }
        this.labels.get(labelName).setDescription(newText);
    }
    
    
    
    
    
    
}
