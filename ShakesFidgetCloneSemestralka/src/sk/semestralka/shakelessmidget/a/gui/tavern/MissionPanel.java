
package sk.semestralka.shakelessmidget.a.gui.tavern;

import sk.semestralka.shakelessmidget.adventure.Mission;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *  Trieda ktorej úlohou je grafické zobrazenie dostupných misií a ich začatie
 * @author marce
 */
public class MissionPanel {

    private JButton startbtn;
    private Font font;
    private Color gold;
    private Color blue;
    private JPanel panel;

    private GridBagConstraints gc;
   
    public MissionPanel(Mission mission, MissonHolder holder) {
        this(mission.getObjective(), holder);
        
    }
    
    public MissionPanel(Objective objective, MissonHolder holder) {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(350, 150));
        this.font = BasicGui.getFont(13);
        
        this.gold = BasicGui.getGoldenColor();
        this.blue = BasicGui.getDarkBlueColor();
        
        this.panel.setBackground(this.blue);
        //  border setup
        Border innerBorder = BorderFactory.createLineBorder(this.gold, 2);
        Border border = BorderFactory.createTitledBorder(innerBorder, "Objective ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, this.font, this.gold); // TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION
        this.panel.setBorder(border);
        
        
        //  gridbaglayout setup
        this.panel.setLayout(new GridBagLayout());
        this.gc = new GridBagConstraints();
        this.gc.gridx = 0;
        this.gc.gridy = 0;
        this.gc.weightx = 1;
        this.gc.weighty = 1;
        this.gc.fill = GridBagConstraints.NONE;
        this.gc.anchor = GridBagConstraints.LINE_START;
        
        this.startbtn = new JButton("Begin");
        //this.startbtn.setFont(this.font);
        this.startbtn.setFont(new Font(BasicGui.getFontName(), Font.BOLD, 15));
        this.startbtn.setBackground(this.gold);
        this.startbtn.setForeground(this.blue);
        this.startbtn.setToolTipText("Click here to begin your new adventure!");
        
        //  labels setup
        this.setup(objective);
        
        //      ABSOLUTE FAILURE
        this.startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                holder.getTavernPanel().showWait(objective);
                
            }
        });
    }
    
    /**
     * Nastavi novu ulohu
     * @param objective nova uloha
     */
    private void setup(Objective objective) {
        if (objective == null) {
            return;
        }
        this.createRow("Name: ", objective.getName());
        this.createRow("Description: ", objective.getDescription());
        this.createRow("Duration: ", String.format("%d seconds" , objective.getDuration()));
        this.createRow("Gold: ", String.valueOf(objective.getGoldReward()));
        this.createRow("Xp: ", String.valueOf(objective.getXpReward()));
        
        
        this.movegc(1, 5);
        this.gc.anchor = GridBagConstraints.LINE_END;
        this.panel.add(this.startbtn, this.gc);
    }
    
    /**
     * Vytvori riadok s danymi stringmi
     * @param title
     * @param detail 
     */
    private void createRow(String title, String detail) {
        this.createLabel(title);
        this.moveRight();
        this.createLabel(detail);
        this.newLine();
        
    }
    
    /**
     * Vytvori label
     * @param text text ktory sa zobrazi v labely
     */
    private void createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.font);
        label.setForeground(this.gold);
        this.panel.add(label, this.gc);
    }
    
    /**
     * Posunie sa o jedno doprava
     */
    private void moveRight() {
        this.gc.gridx++;
    }
    
    /**
     * Posunie sa o jedno dolava
     */
    private void moveDown() {
        this.gc.gridy++;
    }
    
    /**
     * Posunie sa o jedno nizsie
     */
    private void newLine() {
        this.gc.gridx = 0;
        this.gc.gridy++;
    }
    
    /**
     * Posunie sa na zvolene hodnoty
     * @param x stlpec
     * @param y riadok
     */
    private void movegc(int x, int y) {
        this.gc.gridx = x;
        this.gc.gridy = y;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    
    
    
}
