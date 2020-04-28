/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.panels.mainPanels.MainPanel;
import gui.panels.mainPanels.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.player.basic.Player;
import gui.hero.listener.IShowItemListener;
import gui.hero.listener.IUpdatePlayerListener;

/**
 * Trieda HeroPanel sluzi na zobrazenie informacii o hracovi
 */
public class HeroPanel extends MainPanel {

    private final Player player;
    private final HeroStatsPanel2 heroStatsPanel;
    private final ItemDetailsPanel itemDetailsPanel;

    public HeroPanel(Player player) {
        super(PanelType.HERO);
        this.player = player;
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("HERO");
        label.setForeground(Color.white);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
        
        this.heroStatsPanel = new HeroStatsPanel2(this.player);
        this.add(this.heroStatsPanel, BorderLayout.WEST);
        
        this.itemDetailsPanel = new ItemDetailsPanel(this.player);
        this.add(this.itemDetailsPanel, BorderLayout.CENTER);
        
        
        // listenery 
        this.setupListeners();
        
        
    }

    private void setupListeners() {
        this.heroStatsPanel.getInventoryItems().setListener(new IShowItemListener() {
            @Override
            public void itemSelected(Item item) {
                HeroPanel.this.itemDetailsPanel.showInfo(item, true);
                
            }
        });
        
        this.heroStatsPanel.getEquippedItems().setListener(new IShowItemListener() {
            @Override
            public void itemSelected(Item item) {
                HeroPanel.this.itemDetailsPanel.showInfo(item, false);
                
            }
        });
        
        this.itemDetailsPanel.setListener(new IUpdatePlayerListener() {
            @Override
            public void update() {
                HeroPanel.this.updateStats();
            }
        });
        
        
    }
    /**
     * Aktualizuje vsetky hodnoty hraca
     */
    public void updateStats() {
        
        this.heroStatsPanel.updateAll();
    }
    
}
