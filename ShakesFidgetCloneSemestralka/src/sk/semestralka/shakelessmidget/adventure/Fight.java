/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.player.basic.Player;


/**
 * Trieda Fight sluzi na suboj medzi hracom a nepriatelom
 */
public class Fight {
    private enum Turn { PLAYER, ENEMY };
    
    private Player player;
    private Creature enemy;
    
    private boolean ended;
    private boolean playerWin;
    private Turn turn;
    
    private boolean firstStart;
    
    private StringBuilder statusText;

    /**
     * Vytvori sa instancia, nastavia sa pociatocne hodnoty
     * @param player hrac
     * @param enemy nepriatel
     */
    public Fight(Player player, Creature enemy) {
        this.player = player;
        this.player.resetHealth();  //na zaciatku kazdeho fightu hrac zacina s plnym hp
        this.enemy = enemy;
        this.turn = Turn.PLAYER;
        this.ended = false;
        this.playerWin = false;
        
        this.firstStart = true;
        
        this.statusText = new StringBuilder();
        
        
    }
    
    /**
     * Metoda ktora zacne subor. Ak uz sa raz pouzila opat sa neda pouzit.
     */
    public void begin() {
        if (this.firstStart) {
            this.updateStatus(String.format("The fight has begun!"));
            this.updateStatus(String.format("You are fighting against: %s", this.enemy.toString()));
            this.updateStatus(" ");
            this.updateStatus(" ");
            
            this.nextTurn();
            this.firstStart = false;
        }
    }
    
    /**
     * Vrati nepriatela
     * @return 
     */
    public Creature getEnemy() {
        return this.enemy;
    }

    /**
     * Vrati boolean ci sa hra skoncila
     * @return 
     */
    public boolean isEnded() {
        return this.ended;
    }

    /**
     * Vrati boolean ci hrac vyhral
     * @return 
     */
    public boolean playerWin() {
        return this.playerWin;
    }
    
    /**
     * Vrati status vo forme stringu
     * @return 
     */
    public String getStatus() {
        return this.statusText.toString();
    }
    
    
    /**
     * Striedanie turnov medzi enemy a playerom
     */
    private void nextTurn() {
        if (this.ended) {
            return;
        }

        if (this.turn == Turn.PLAYER) {
            this.player.attack(this.enemy);
            this.updateStatus(String.format("           Enemy takes %d damage. Remaining health = %d", 
                    this.player.getDamage(), this.enemy.getCurrentHealth()));
            
            this.turn = Turn.ENEMY;
            if (this.enemy.isDead()) {
                this.updateStatus("You have killed the enemy with ease.");
                this.ended = true;
                this.playerWin = true;
            }
            
        } else {
            
            this.enemy.attack(this.player);
            int dmg = this.enemy.getDamage() - (this.player.getArmor() + this.player.getBonusHealth());
            if (dmg < 0) {
                dmg = 0;
            }
            
            this.updateStatus(String.format("   You take %d damage. Your remaining health = %d", dmg, this.player.getCurrentHealth()));    
            this.turn = Turn.PLAYER;
            if (this.player.isDead()) {
                this.updateStatus("You have suffered a humiliating defeat!");
                this.ended = true;
                this.playerWin = false;
            }
            
        } 
        this.nextTurn();
        
    }

    /**
     * Aktualizuje status
     * @param text 
     */
    private void updateStatus(String text) {
        this.statusText.append(text);
        this.statusText.append("\n");
    }  
    
    
}
