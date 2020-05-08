
package sk.semestralka.shakelessmidget.a.gui.menu;

import sk.semestralka.shakelessmidget.a.gui.basic.BasicGui;
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
import sk.semestralka.shakelessmidget.main.Game;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;

/**
 * Trieda sluzi na ulozenie buttonov na spodku menu
 * @author marce
 */
public class LowerButtonsPanel {

    private final Game game;
    private final JButton newGameButton;
    private final JButton testButton;

    private JPanel panel;
    /**
     * Vytvori potrebne komponenty a nastavi pociatocne hodnoty
     * @param game 
     */
    public LowerButtonsPanel(Game game) {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
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
        
        this.panel.setBackground(new Color(26, 26, 53));
        
        this.panel.setPreferredSize(new Dimension(50, 200));
        
        this.testButton = new JButton("");
        this.testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LowerButtonsPanel.this.game.giveALittleBoost();
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
        
        this.panel.add(this.testButton);
        this.panel.add(Box.createRigidArea(new Dimension(0, 5)));
        this.panel.add(this.newGameButton);
        
        
        
    }
    
    /**
     * Vrati panel
     * @return panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    /**
     * Nastavenie tlacidla
     * @param button 
     */
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
