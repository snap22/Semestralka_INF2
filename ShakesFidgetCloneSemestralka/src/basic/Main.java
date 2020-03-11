/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import creatures.Creature;
import creatures.Imp;
import creatures.Player;
import creatures.specialCharacters.KamikazeeGuy;


/**
 *
 * @author marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creature imp = new Imp("Imp", 20, 10);
        
        Creature player = new Player(10, 10, new KamikazeeGuy());
        player.attack(imp);
        
        
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