/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.a.gui.tavern;

import sk.semestralka.shakelessmidget.a.gui.main.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.generators.Generator;
import sk.semestralka.shakelessmidget.a.gui.tavern.HeadPanel;
import sk.semestralka.shakelessmidget.a.gui.tavern.MissionPanel;
import sk.semestralka.shakelessmidget.a.gui.tavern.MissonHolder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 * Trieda TavernPanel sluzi na zobrazenie dostupnych uloh a na prepinanie medzi vybranymi scenkami
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
    private Objective tempobj;
    
    /**
     * Konstruktor, zobrazi panel
     * @param game hra
     */
    public TavernPanel(Game game) {
        super(PanelType.TAVERN);
        this.setLayout(new BorderLayout());
        
        this.game = game;
        this.missionsPanel = new MissonHolder(this, game);
        this.waitPanel = new WaitPanel(this, game.getPlayer());
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
    
    /**
     * Ukaze FightPanel, t.j priebeh suboja medzi hracom a nepriatelom
     */
    public void showFight() {
        this.fightPanel.setup(this.tempobj);
        this.headPanel.changeTitle("Dangerous fight in progress");
        this.card.show(this.temporaryPanel, "2");
    }
    
    /**
     * Ukaze cakaci panel, t.j panel kde hrac musi cakat
     * @param obj 
     */
    public void showWait(Objective obj) {
        this.headPanel.changeTitle("Waiting eagerly...");
        this.waitPanel.setup(obj);
        this.tempobj = obj;
        this.card.show(this.temporaryPanel, "1");
        this.missionsPanel.restart();
    }
    
    /**
     * Ukaze dostupne misie
     */
    public void showMissions() {
        this.headPanel.changeTitle("Choose your adventure");
        this.card.show(this.temporaryPanel, "0");
    }
   
    
    
    
    
    
}
