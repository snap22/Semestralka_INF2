/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda HeroStatsPanel sluzi pre zobrazovanie zakladnych informacii o hracovi
 */
public class HeroStatsPanel extends JPanel {
    
    private HashMap<String, HeroStatLabel> labels;
    private final Player player;
    private JProgressBar bar;

    /**
     * Konstruktor pre triedu, vytvoria sa udaje ktore udavaju zakladne informacie o hracovi
     * @param player 
     */
    public HeroStatsPanel(Player player) {
        this.player = player;
        this.labels = new HashMap<String, HeroStatLabel>();
        this.bar = new JProgressBar(0, this.player.getRequiredXp());
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.createLabel("Name", player.getName());
        this.createLabel("Health", player.getHealth());
        this.createLabel("Armor", player.getArmor());
        this.createLabel("Damage", player.getDamage());
        this.createLabel("Level", player.getLevel());
        this.createLabel("Gold", player.getGold());
        
        //this.bar.setMaximumSize(new Dimension(150, 20));
        this.add(Box.createRigidArea(new Dimension(5, 30)));
        
        this.add(this.bar);
        this.bar.setStringPainted(true);
        this.bar.setForeground(Color.orange);
        this.bar.setString("XP");
        this.setBackground(Color.green);
        
    }
    
    /**
     * Aktualizuje text v kazdom labely
     */
    public void updateAll() {
        this.updateText("Health", this.player.getHealth());
        this.updateText("Armor", this.player.getArmor());
        this.updateText("Damage", this.player.getDamage());
        this.updateText("Level", this.player.getLevel());
        this.updateText("Gold", this.player.getGold());
        this.updateBar();
        
        
    }
    
    private void updateBar() {
        this.bar.setMaximum(this.player.getRequiredXp());
        this.bar.setValue(this.player.getCurrentXp());
    }
    
    private void createLabel(String name, int description) {
        this.createLabel(name, String.valueOf(description));
    }
    
    private void createLabel(String name, String description) {
        if (name == null || description == null) {
            return;
        }
        
        HeroStatLabel newLabel = new HeroStatLabel(name, description);
        this.labels.put(name, newLabel);
        this.add(newLabel);
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
