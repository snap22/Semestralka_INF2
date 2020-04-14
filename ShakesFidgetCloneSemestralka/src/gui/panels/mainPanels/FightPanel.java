/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;


import gui.BasicGui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    private final JTextArea text;

    public FightPanel(Player player, Objective obj, TavernPanel tav) {
        super(PanelType.FIGHT);
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.player = player;
        this.obj = obj;
        this.tav = tav;
        
        JButton change = new JButton("Return back");
        change.setFont(BasicGui.getFont(20));
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        
        this.add(change, BorderLayout.SOUTH);
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // tav.showFight(); //zmenit cez listener
                tav.showMissions();
            }
        });
        this.text = new JTextArea();
        JScrollPane scroll = new JScrollPane(this.text);
        
        
        
        this.add(scroll, BorderLayout.CENTER);
        this.test();
        
       
        this.text.setFont(BasicGui.getFont(15));
        this.text.setEditable(false);
        
        
    }

    public FightPanel(Player player, TavernPanel tav) {
        this(player, null, tav);
    }
    
    private void test() {
        for (int i = 0; i < 100; i++) {
            this.appendPlayerText("Player takes 5 damage");
            this.appendEnemyText("Enemy takes 150 damage.");
        }
        this.clear();
    }
    
    public void appendPlayerText(String newText) {
        this.createLine();
        this.text.append(String.format("%s %n", newText));
        
    }
    
    public void appendEnemyText(String newText) {
        this.createLine();
        this.text.append(String.format("%s %s %n", this.createEmptyGap(80), newText));
        
    }
    
    private String createShit(int length, char c, boolean br) {
        if (length < 0) {
            length = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        if (br) {
            sb.append("\n");
        }
        
        return sb.toString();
        
    }
    
    public void clear() {
        this.text.setText("");
    }
    
    private String createEmptyGap(int length) {
        return this.createShit(length, ' ', false);
    }
    
    private void createLine() {
        this.text.append(this.createShit(89, '-', true));
        
    }
    
    public void setup(Objective obj) {
        this.obj = obj;
    }
}
