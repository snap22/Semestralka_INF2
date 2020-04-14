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
import java.awt.Component;
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
    private WaitPanel waitPanel;
    private final FightPanel fightPanel;
    private final HeadPanel headPanel;
    
    public TavernPanel(Game game) {
        super(PanelType.TAVERN);
        this.setLayout(new BorderLayout());
        
        this.game = game;
        this.missionsPanel = new MissonHolder(this, game);
        this.waitPanel = new WaitPanel(this);
        this.fightPanel = new FightPanel(game.getPlayer(), this);
        
        this.temporaryPanel = new JPanel();
        this.card = new CardLayout();
        this.temporaryPanel.setLayout(this.card);
        this.headPanel = new HeadPanel("Choose your adventure");
        
        this.add(this.headPanel, BorderLayout.NORTH);
        this.add(this.temporaryPanel, BorderLayout.CENTER);
        
        this.setBackground(Color.black);
        this.temporaryPanel.add(this.missionsPanel, "0");
        this.temporaryPanel.add(this.waitPanel, "1");
        this.temporaryPanel.add(this.fightPanel, "2");
        
    }
    
    public void showFight() {
        this.headPanel.changeTitle("Dangerous fight in progress");
        this.card.show(this.temporaryPanel, "2");
    }
    
    public void showWait(Objective obj) {
        this.headPanel.changeTitle("Waiting eagerly...");
        this.waitPanel.setup(obj);
        this.card.show(this.temporaryPanel, "1");
        this.missionsPanel.restart();
    }
    
    public void showMissions() {
        this.headPanel.changeTitle("Choose your adventure");
        this.card.show(this.temporaryPanel, "0");
    }
   
    
    
    
    
    
}
