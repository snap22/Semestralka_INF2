/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tavern.adventure;

import gui.panels.mainPanels.TavernPanel;
import java.awt.Color;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 * Trieda MissionHolder sluzi na zobrazenie informacii o misii
 */
public class MissonHolder extends JPanel {

    private MissionPanel[] adventures;
    private final TavernPanel panel;
    private final Game game;

    /**
     * Konstruktor, vytvori instanciu a zobrazi hodnoty
     * @param panel Tavern Panel
     * @param game hra
     */
    public MissonHolder(TavernPanel panel, Game game) {
        this.adventures = new MissionPanel[3];
        this.panel = panel;
        this.game = game;
        //Bez layoutu! iba default
        this.setBackground(Color.black);
        this.restart();
    }
    
    /**
     * Vytvori novu misiu ktora sa zobrazi
     */
    public void restart() {
        this.clear();
        for (int i = 0; i < this.adventures.length; i++) {
            this.createMission(i);
        }
    }
    
    /**
     * Vrati Tavern Panel
     * @return 
     */
    public TavernPanel getPanel() {
        return this.panel;
    }
    
    /**
     * Vytvori misiu a jej hodnoty sa zobrazia
     * @param i 
     */
    private void createMission(int i) {
        if (i < 0 || i >= this.adventures.length) {
            return;
        }
        Objective obj = this.game.getGenerator().generateObjective();
        
        this.adventures[i] = new MissionPanel(obj, this);
        this.add(this.adventures[i]);
    }
    
    /**
     * Vycisti vsetky informacie
     */
    private void clear() {
        for (int i = 0; i < this.adventures.length; i++) {
            if (this.adventures[i] == null) {
                continue;
            }
            this.remove(this.adventures[i]);
        }
    }


}
