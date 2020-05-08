
package sk.semestralka.shakelessmidget.a.gui.firstAndShop;

import sk.semestralka.shakelessmidget.a.gui.basic.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.basic.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import sk.semestralka.shakelessmidget.a.gui.basic.BasicGui;


/**
 * Trieda WelcomePanel sluzi ako uvitacia trieda pre hraca ked spusti hru
 * Pocas hry nie je mozne opat sa dostat do tohto panela
 */
public class WelcomePanel extends MainPanel {

    private JScrollPane panel;

    /**
     * Vytvori potrebne komponenty
     */
    public WelcomePanel() {
        super(PanelType.WELCOME);
        super.getPanel().setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to the game");
        label.setForeground(Color.white);
        label.setFont(BasicGui.getFont(50));
        super.getPanel().setBackground(Color.black);
        super.getPanel().add(label, BorderLayout.NORTH);
        
        ImageIcon icon = new ImageIcon("files/logoSmall.png");
        JLabel imgLabel = new JLabel(icon);
        super.getPanel().add(imgLabel, BorderLayout.CENTER);
    }

}
