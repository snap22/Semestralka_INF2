/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import gui.BasicGui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import sk.semestralka.shakelessmidget.basic.Game;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;

/**
 *
 * @author marce
 */
public class LowerButtonsPanel extends JPanel {

    private final Game game;
    private final JButton newGameButton;
    private final JButton testButton;

    public LowerButtonsPanel(Game game) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.game = game;
        this.newGameButton = new JButton("New game");
        this.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LowerButtonsPanel.this.reset();
            }
        });
        this.newGameButton.setFocusable(false);
        this.setupButton(this.newGameButton);
        
        this.setBackground(new Color(26, 26, 53));
        
        this.setPreferredSize(new Dimension(50, 200));
        
        this.testButton = new JButton("");
        this.testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LowerButtonsPanel.this.game.test();
                } catch (InventoryFullException ex) {
                    //
                }
            }
        });
        
        Border border = BorderFactory.createLineBorder(new Color(26, 26, 53));
        this.testButton.setBorder(border);
        this.testButton.setMaximumSize(new Dimension(40, 40));
        this.testButton.setBackground(new Color(26, 26, 53));
        this.testButton.setFocusable(false);
        
        this.add(this.testButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(this.newGameButton);
        
        
        
    }
    
    private void setupButton(JButton button) {
        button.setFont(BasicGui.getFont());
        button.setForeground(BasicGui.getGoldenColor());
        button.setBackground(BasicGui.getDarkBlueColor());
    }
    
    /**
     * Vytvori sa okno a spyta sa hraca ci chce restartovat hru
     */
    private void reset() {
        JOptionPane pane = new JOptionPane();
        int f = (Integer)pane.showConfirmDialog(
                null, 
                "To play a new game you have to restart.\n Do you want to proceed? ", 
                "Restart required", 
                JOptionPane.YES_NO_OPTION
        );
        if (f == 0) {   //ak stlacene YES
            this.game.newGame();
        } 
    }
}
