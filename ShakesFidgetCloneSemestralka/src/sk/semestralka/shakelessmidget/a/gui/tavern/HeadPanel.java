
package sk.semestralka.shakelessmidget.a.gui.tavern;

import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Trieda HeadPanel sluzi cisto ako Header pre jednotlive MainPanely
 */
public class HeadPanel {

    private final JLabel label;
    private final JPanel panel;

    /**
     * Vytvori potrebne komponenty
     * @param name 
     */
    public HeadPanel(String name) {
        this.panel = new JPanel();
        
        this.label = new JLabel(name);
        this.label.setFont(BasicGui.getFont(40));
        this.label.setForeground(Color.white);
        this.panel.add(this.label);
      
        this.panel.setBackground(Color.black);
    }
    
    /**
     * Zmeni text
     * @param text novy text ktory sa zobrazi
     */
    public void changeTitle(String text) {
        this.label.setText(text);
    }
    
    /**
     * Vrati panel
     * @return  panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    
}
