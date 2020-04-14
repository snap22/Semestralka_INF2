/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.generators.Generator;
import gui.BasicGui;
import gui.tavern.adventure.HeadPanel;
import gui.tavern.adventure.MissionPanel;
import gui.tavern.adventure.MissonHolder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 *
 * @author marce
 */
public class TavernPanel extends MainPanel {

    private MissionPanel[] adventures;
    private Generator gen;
    
    private JPanel temporaryPanel;
    private MissonHolder missionsPanel;
    private final Game game;
    private final CardLayout card;
    
    public TavernPanel(Game game) {
        super(PanelType.TAVERN);
        this.setLayout(new BorderLayout());
        
        this.game = game;
        this.missionsPanel = new MissonHolder(this, game);
        
        
        this.temporaryPanel = new JPanel();
        this.card = new CardLayout();
        this.temporaryPanel.setLayout(this.card);
        
        
        this.add(new HeadPanel("Choose your adventure"), BorderLayout.NORTH);
        this.add(this.temporaryPanel, BorderLayout.CENTER);
        
        this.setBackground(Color.black);
        this.setMissions();
    }
    
    public void setWait(Objective obj) {
        WaitPanel newPanel = new WaitPanel(obj, this);
        this.temporaryPanel = newPanel;
        this.temporaryPanel.add(newPanel, "1");
        this.card.show(this.temporaryPanel, "1");
    }
    
    public void setFight() {
        FightPanel newPanel = new FightPanel();
        this.temporaryPanel = newPanel;
        this.temporaryPanel.add(newPanel, "2");
        this.card.show(this.temporaryPanel, "2");
    }
    
    public void setMissions() {
        
        this.temporaryPanel.add(this.missionsPanel, "0");
        this.card.show(this.temporaryPanel, "0");
        this.missionsPanel.restart();
    }
    
   
    
    
    
    
    
}
