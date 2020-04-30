/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 * Zatial nic  nerobi
 */
public class MiniGamePanel extends MainPanel {

    private Game game;

    public MiniGamePanel() {
        super(PanelType.MINIGAME);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("THIS IS A FREAKING MINIGAAME");
        label.setForeground(Color.YELLOW);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.blue);
        this.add(label, BorderLayout.NORTH);
        
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("NEW");
        this.add(saveButton, BorderLayout.WEST);
        this.add(loadButton, BorderLayout.EAST);
        
        
        //toto pekne vymazat, pekne sa to buguje
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.newGame();
            }
        });
        
        JButton testButton = new JButton("test");
        this.add(testButton);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.test();
            }
        });
    }

    public MiniGamePanel(Game game) {
        this();
        this.game = game;
    }
    
    private void reset() {
        JOptionPane pane = new JOptionPane();
        int f = (Integer)pane.showConfirmDialog(
                null, 
                "To play a new game you have to restart.\n Do you want to proceed? ", 
                "Silly question", 
                JOptionPane.YES_NO_OPTION
        );
        if (f == 0) {   //ak stlacene YES
            this.game.newGame();
        } 
    }
    /*
    int n = JOptionPane.showConfirmDialog(
    frame,
    "Would you like green eggs and ham?",
    "An Inane Question",
    JOptionPane.YES_NO_OPTION);

    */
}
