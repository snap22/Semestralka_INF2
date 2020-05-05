
package sk.semestralka.shakelessmidget.a.gui.tavern;

import java.awt.Color;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 * Trieda MissionHolder sluzi na zobrazenie informacii o misii
 */
public class MissonHolder {

    private MissionPanel[] adventures;
    private JPanel panel;
    private final Game game;
    private final TavernPanel tavern;

    /**
     * Konstruktor, vytvori instanciu a zobrazi hodnoty
     * @param tavernPanel Tavern Panel
     * @param game hra
     */
    public MissonHolder(TavernPanel tavernPanel, Game game) {
        this.panel = new JPanel();
        this.adventures = new MissionPanel[3];
        this.tavern = tavernPanel;
        this.game = game;
        //Bez layoutu! iba default
        this.panel.setBackground(Color.black);
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
    public TavernPanel getTavernPanel() {
        return this.tavern;
    }
    
    public JPanel getPanel() {
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
        this.panel.add(this.adventures[i].getPanel());
    }
    
    /**
     * Vycisti vsetky informacie
     */
    private void clear() {
        for (int i = 0; i < this.adventures.length; i++) {
            if (this.adventures[i] == null) {
                continue;
            }
            this.panel.remove(this.adventures[i].getPanel());
        }
    }


}
