/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.player.basic.Player;


/**
 * Trieda, ktorej ulohou je sledovať dopad hraca v suboji s nepriatelom a podla toho mu prideliť odmenu
 */
public class Mission {

    private Objective objective;
    private Fight fight;
    private Player player;

    public Mission(Objective objective, Player player) {
        this.objective = objective;
        this.player = player;
        
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
        
        
    }

    public Objective getObjective() {
        return this.objective;
    }

    public Fight getFight() {
        return this.fight;
    }

    public Player getPlayer() {
        return this.player;
    }
    
    
}
