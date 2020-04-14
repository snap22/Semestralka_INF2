/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka.game.player.basic;

import semestralka.game.items.Item2;

/**
 *
 * Stara sa o informacie kolko missii splnil, kolkych enemy zabil, s kolkymi bojoval (% uspesnost), kolko itemov ziskal, 
 * kolko common/uncommon/rare/epic itemov vlastnil, kolko goldov ziskal dokopy, aky ma level
 */
public class PlayerStats {
    private int creaturesKilled;
    private int missionsCompleted;
    private int missionsEntered;
    private int enemiesEncountered;
    private int enemiesKilled;
    // + percentualna uspesnost pre enemy
    private int itemsGained;
    private int commonItems;
    private int uncommonItems;
    private int rareItems;
    private int epicItems;
    
    private int overallXpGained;

    public PlayerStats() {
        this.overallXpGained = 0;
    }
    
    
    
    public void gainedItem(Item2 item) {
        if (item == null) {
            return;
        }
        switch (item.getRarity()) {
            case COMMON:
                this.commonItems++;
                break;
            case UNCOMMON:
                this.uncommonItems++;
                break;
            case RARE:
                this.rareItems++;
                break;
            case EPIC:
                this.epicItems++;
                break;
        }
        this.itemsGained++;
    }
    
}
