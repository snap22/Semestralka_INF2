
package sk.semestralka.shakelessmidget.a.gui.tavern;

import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Trieda HeadPanel sluzi cisto ako Header pre jednotlive MainPanely
 */
public class HeadPanel extends JPanel {

    private final JLabel label;

    /**
     * Vytvori potrebne komponenty
     * @param name 
     */
    public HeadPanel(String name) {
        this.label = new JLabel(name);
        this.setBackground(Color.black);
        this.label.setFont(BasicGui.getFont(40));
        this.label.setForeground(Color.white);
        this.add(this.label);
    }
    
    /**
     * Zmeni text
     * @param text novy text ktory sa zobrazi
     */
    public void changeTitle(String text) {
        this.label.setText(text);
    }
}
