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
 * Trieda HeroStatLabel sluzi na zobrazenie daneho udaju
 */
public class HeroStatLabel extends JLabel {

    private final String nameText;
    private String description;

    /**
     * Konštruktor ktory berie 2 stringy, jeden pre nazov druhy pre description
     * @param name  nazov 
     * @param description popis, upresnujuci udaj
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
     * Nastavi popis podla danych hodnot. Vysledne sa ukaze ako retazec vo forme
     * " <i> zaciatocne cislo} </i> / <i> koncove cislo </i> "
     * @param current zaciatocne cislo
     * @param required  koncove cislo
     */
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
    
    
    /**
     * Aktualizuje text
     */
    private void updateText() {
        String newText = String.format("%s : %s", this.nameText, this.description);
        super.setText(newText);
    }
    
    
}
