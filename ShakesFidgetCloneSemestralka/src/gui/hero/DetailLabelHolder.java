/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *  Trieda sa stara o spravu labelov
 */
public class DetailLabelHolder extends JPanel {

    private final HashMap<String, DetailLabel> labels;

    /**
     * Konstruktor aktualizuje pociatocne hodnoty
     */
    public DetailLabelHolder() {
        this.labels = new HashMap<String, DetailLabel>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
    }
    
    /**
     * Prida novy label
     * @param name nazov
     * @param description popis 
     */
    public void addLabel(String name, String description) {
        DetailLabel newLabel = new DetailLabel(name, description);
        this.labels.put(name, newLabel);
        this.add(newLabel);
        
    }
    
    /**
     * Prida novy label
     * @param name nazov
     * @param description popis
     */
    public void addLabel(String name, int description) {
        this.addLabel(name, String.valueOf(description));
    }
    
    /**
     * Aktualizuje popis v labely
     * @param labelName nazov
     * @param newText novy popis
     */
    public void updateText(String labelName, String newText) {
        if (!this.labels.containsKey(labelName)) {
            return;
        }
        this.labels.get(labelName).setDescription(newText);
    }
    
    /**
     * Aktualizuje popis v labely
     * @param labelName nazov
     * @param newText novy popis
     */
    public void updateText(String labelName, int newText) {
        this.updateText(labelName, String.valueOf(newText));
    }
    
    /**
     * Zmaze vsetky labely
     */
    public void clear() {
        this.labels.clear();
    }
}
