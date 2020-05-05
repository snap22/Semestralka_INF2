
package sk.semestralka.shakelessmidget.a.gui.hero;

import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * Trieda DetailLabel sluzi na zobrazenie daneho udaju
 */
public class DetailLabel {

    private final String nameText;
    private String description;
    private JLabel label;

    /**
     * Konštruktor ktory berie 2 stringy, jeden pre nazov druhy pre description
     * @param name  nazov 
     * @param description popis, upresnujuci udaj
     */
    public DetailLabel(String name, String description) {
        this.label = new JLabel();
        this.nameText = name;
        this.description = description;
        this.label.setFont(BasicGui.getFont(18));
        this.label.setBackground(Color.white);
        this.label.setOpaque(true);
        
        this.updateText();
    }

    /**
     * Nastavi popis podla danej hodnoty
     * @param newDescription nový text ktorý chceme mať v danom labely
     */
    public void setDescription(String newDescription) {
        if (newDescription == null) {
            return;
        }
        
        this.description = newDescription;
        this.updateText();
    }
    
    /**
     * Nastavi popis podla danej hodnoty
     * @param newDescription  cislo, ktore sa ukaze v popise
     */
    public void setDescription(int newDescription) {
        this.setDescription(String.valueOf(newDescription));
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

    public JLabel getLabel() {
        return this.label;
    }
    
    
    
    /**
     * Aktualizuje text
     */
    private void updateText() {
        String newText = String.format("%s : %s", this.nameText, this.description);
        this.label.setText(newText);
    }
    
    
    
}
