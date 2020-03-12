/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import creatures.Player;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author marce
 */
public class Mission {

    private Objective mission;
    private Fight fight;
    private Player player;

    public Mission(Objective mission, Player player) {
        this.mission = mission;
        this.player = player;
        
        this.fight = new Fight(this.player, this.mission.getEnemy());
    }
    
    
    public void start() {
        try {
            TimeUnit.SECONDS.sleep(this.mission.getDuration());
        } catch (InterruptedException ex) {
            
        }
        
        this.fight.begin();
        if (this.fight.playerWin()) {
            this.mission.complete();
            this.mission.giveReward(this.player);
        }
        
        
    }
}
