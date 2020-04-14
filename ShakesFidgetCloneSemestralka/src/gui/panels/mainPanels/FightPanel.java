/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.player.basic.Player;


/**
 *
 * @author marce
 */
public class FightPanel extends MainPanel {

    private Objective obj;
    private final Player player;
    private final TavernPanel tav;

    public FightPanel(Player player, Objective obj, TavernPanel tav) {
        super(PanelType.FIGHT);
        this.setBackground(Color.green);
        this.player = player;
        this.obj = obj;
        this.tav = tav;
        
        JButton change = new JButton("change");
        this.add(change);
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // tav.showFight(); //zmenit cez listener
                tav.showMissions();
            }
        });
        
    }

    public FightPanel(Player player, TavernPanel tav) {
        this(player, null, tav);
    }
    
    
    
    
    
    public void setup(Objective obj) {
        this.obj = obj;
    }
}
