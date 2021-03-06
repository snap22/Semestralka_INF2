/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.a.gui.tavern.FightPanel;
import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Trieda, ktorej ulohou je sledovať dopad hraca v suboji s nepriatelom a podla toho mu prideliť odmenu
 */
public class Mission {

    private Objective objective;
    private Fight fight;
    private Player player;
    private final FightPanel panel;

    /**
     * Konstruktor, vytovri instanciu
     * @param objective uloha
     * @param player hrac
     * @param panel panel na ktorom sa to ma zobrazit
     */
    public Mission(Objective objective, Player player, FightPanel panel) {
        this.objective = objective;
        this.player = player;
        this.panel = panel;
        
        this.fight = new Fight(this.player, this.objective.getEnemy());
    }
    
    /**
     * Metoda ktora zacne misiu t.j. zacne sa suboj. Ak ho hrac vyhra dostane odmenu
     */
    public void start() {
        this.fight.begin();
        if (this.fight.playerWin()) {
            this.objective.complete();
            this.objective.giveReward(this.player);
        }
        
        this.panel.appendText(this.fight.getStatus());
        this.panel.appendText("\n");
        this.panel.appendText(this.objective.getStatus());
        
        
    }

    /**
     * Vrati ulohu
     * @return uloha
     */
    public Objective getObjective() {
        return this.objective;
    }

    /**
     * Vrati triedu Fight
     * @return fight
     */
    public Fight getFight() {
        return this.fight;
    }

    /**
     * Vrati hraca
     * @return hrac
     */
    public Player getPlayer() {
        return this.player;
    }
    
    
}
