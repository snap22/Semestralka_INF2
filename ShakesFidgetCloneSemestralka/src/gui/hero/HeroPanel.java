/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.hero.HeroStatsPanel;
import gui.panels.mainPanels.MainPanel;
import gui.panels.mainPanels.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 * Trieda HeroPanel sluzi na zobrazenie informacii o hracovi
 */
public class HeroPanel extends MainPanel {

    private final Player player;
    private final HeroStatsPanel2 statsPanel;
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
        
        this.statsPanel = new HeroStatsPanel2(this.player);
        this.add(this.statsPanel, BorderLayout.WEST);
        
        this.itemDetailsPanel = new ItemDetailsPanel();
        this.add(this.itemDetailsPanel, BorderLayout.CENTER);
    }

    /**
     * Aktualizuje vsetky hodnoty hraca
     */
    public void updateStats() {
        this.statsPanel.updateAll();
    }
    
}
