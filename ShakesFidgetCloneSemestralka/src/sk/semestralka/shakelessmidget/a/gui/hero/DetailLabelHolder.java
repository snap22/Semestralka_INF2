
package sk.semestralka.shakelessmidget.a.gui.hero;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *  Trieda sa stara o spravu labelov
 */
public class DetailLabelHolder {

    private final HashMap<String, DetailLabel> labels;
    private final JPanel panel;

    /**
     * Konstruktor aktualizuje pociatocne hodnoty
     */
    public DetailLabelHolder() {
        this.panel = new JPanel();
        this.labels = new HashMap<String, DetailLabel>();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.setBackground(Color.white);
    }
    
    /**
     * Prida novy label
     * @param name nazov
     * @param description popis 
     */
    public void addLabel(String name, String description) {
        DetailLabel newLabel = new DetailLabel(name, description);
        this.labels.put(name, newLabel);
        this.panel.add(newLabel.getLabel());
        
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
    
    public void hideLabel(String labelName) {
        this.toggleVisible(labelName, false);
    }
    
    public void showLabel(String labelName) {
        this.toggleVisible(labelName, true);
    }
    
    public DetailLabel getLabel(String labelName) {
        if (!this.labels.containsKey(labelName)) {
            return null;
        }
        
        return this.labels.get(labelName);
    }
    
    private void toggleVisible(String labelName, boolean visible) {
        if (!this.labels.containsKey(labelName)) {
            return;
        }
        this.labels.get(labelName).getLabel().setVisible(visible);
    }
    
    /**
     * Zmaze vsetky labely
     */
    public void clear() {
        this.labels.clear();
    }

    public JPanel getPanel() {
        return this.panel;
    }
    
    
}
