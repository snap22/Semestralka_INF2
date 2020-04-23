/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import gui.BasicGui;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class HeroStatLabel extends JLabel {

    private final String nameText;
    private String description;

    /**
     * Konštruktor ktory berie 2 stringy, jeden pre nazov druhy pre description
     * @param name
     * @param description 
     */
    public HeroStatLabel(String name, String description) {
        super("");      //bez toho to ani neukaze
        this.nameText = name;
        this.description = description;
        this.setFont(BasicGui.getFont(18));
        this.setForeground(Color.WHITE);
        this.setBackground(Color.red);
        this.setOpaque(true);
        
        this.updateText();
        
    }

    /**
     * Konštruktor pre pripady, ked by bolo potrebne vytvoriť inštanciu s textom ktory udava 
     * kolko danej hodnoty mame a kolko treba, napr. pri xp
     * @param name
     * @param current
     * @param required 
     */
    public HeroStatLabel(String name, int current, int required) {
        this(name, String.format("%d / %d", current, required));
    }
    
    
    /**
     * Aktualizuje text
     */
    private void updateText() {
        String newText = String.format("%s : %s", this.nameText, this.description);
        super.setText(newText);
    }
    
    /**
     * Zmeni hodnotu v description
     * @param newDescription nový text ktorý chceme mať v danom labely
     */
    public void setDescription(String newDescription) {
        if (newDescription == null) {
            return;
        }
        
        this.description = newDescription;
        this.updateText();
    }
    
    public void setDescription(int newDescription) {
        this.setDescription(String.valueOf(newDescription));
    }
    
    public void setDescription(int current, int required) {
        this.description = String.format("%d / %d", current, required);
    }
    
    /**
     * Vrati description
     * @return 
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Vrati name
     * @return 
     */
    public String getNameText() {
        return this.nameText;
    }
    
    
    
}
