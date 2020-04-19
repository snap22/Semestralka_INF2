/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.adventure;

import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.player.basic.Player;


/**
 *
 * 
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

    public Fight(Player player, Creature enemy) {
        this.player = player;
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
            this.updateStatus(String.format("The start has begun!"));
            this.updateStatus(String.format("You are fighting against: %s", this.enemy.toString()));
            this.nextTurn();
            this.firstStart = false;
        }
    }
    
    private void nextTurn() {
        if (this.ended) {
            return;
        }

        if (this.turn == Turn.PLAYER) {
            this.player.attack(this.enemy);
            this.updateStatus(String.format("Enemy takes %d damage.", this.player.getDamage()));
            
            this.turn = Turn.ENEMY;
            if (this.enemy.isDead()) {
                this.updateStatus("The player killed the enemy with ease. GG WP EZ");
                this.ended = true;
                this.playerWin = true;
            }
            
        } else {
            
            this.enemy.attack(this.player);
            int dmg = this.enemy.getDamage() - (this.player.getArmor() + this.player.getHealth());
            this.updateStatus(String.format("Player takes %d damage.", dmg));    
            this.turn = Turn.PLAYER;
            if (this.player.isDead()) {
                this.updateStatus("The player has suffered a humiliating defeat!");
                this.ended = true;
                this.playerWin = false;
            }
            
        } 
        this.nextTurn();
        
    }

    public Creature getEnemy() {
        return this.enemy;
    }

    public boolean isEnded() {
        return this.ended;
    }

    public boolean playerWin() {
        return this.playerWin;
    }
    
    
    
    private void updateStatus(String text) {
        this.statusText.append(text);
        this.statusText.append("\n");
    }  
    
    
    public String getStatus() {
        return this.statusText.toString();
    }
}





/*
public class Fight {

    private boolean ended;
    private boolean playerWin;
    
    
    
    private final Player player;
    private final Enemy enemy;
    
    
    enum Turn { PLAYER, ENEMY, END };
    private Turn turn;

    public Fight(Objective objective) {
        this.turn = Turn.PLAYER;
        this.player = objective.getPlayer();
        this.enemy = objective.getEnemy();
        this.ended = false;
        
        this.playerWin = false;
        
        while (!this.ended) {
            this.nextTurn();
        }
    }
    
    private void nextTurn() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Fight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if (this.turn == Turn.PLAYER) {
            this.enemy.takeDamage(this.player.getDamage());
            // + damage z nejakeho efektu / itemu
            if (this.enemy.isDead()) {
                this.turn = Turn.END;
                this.ended = true;
                System.out.println("Player won");
                this.playerWin = true;
                return;
            }
            this.turn = Turn.ENEMY;
            
        } else if (this.turn == Turn.ENEMY) {
            this.player.takeDamage(this.enemy.getDamage());
            if (this.player.isDead()) {
                this.turn = Turn.END;
                this.ended = true;
                System.out.println("Enemy won");
                return;
            }
            this.turn = Turn.PLAYER;
        } else {
            System.out.println("Game has already ended");
            
        }
        
    }
    
    public boolean playerWon() {
        return this.playerWin;
    }
    
    
    
}
*/