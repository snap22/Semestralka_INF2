/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import gui.hero.HeroStatsPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class HeroPanel extends MainPanel {

    private final Player player;
    private final HeroStatsPanel statsPanel;

    public HeroPanel(Player player) {
        super(PanelType.HERO);
        this.player = player;
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("HERO");
        label.setForeground(Color.white);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
        
        this.statsPanel = new HeroStatsPanel(this.player);
        this.add(this.statsPanel, BorderLayout.CENTER);
    }

    public void updateStats() {
        this.statsPanel.updateAll();
    }
    
}
