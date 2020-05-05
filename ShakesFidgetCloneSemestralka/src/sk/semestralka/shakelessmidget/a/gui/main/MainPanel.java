
package sk.semestralka.shakelessmidget.a.gui.main;


import java.awt.Component;
import javax.swing.JPanel;

/**
 *  Trieda MainPanel sluzi len ako nadtyp pre hlavne panely ktore sa budu v hre menit podla interakcie hraca
 */
public abstract class MainPanel {
    private JPanel panel;
    private PanelType type;
    
    /**
     * Konstruktor, uklada si typ panela
     * @param type 
     */
    public MainPanel(PanelType type) {
        this.panel = new JPanel();
        this.type = type;
    }

    /**
     * Vrati typ panela
     * @return 
     */
    public PanelType getType() {
        return this.type;
    }
    
    /**
     * Vrati typ panela vo forme stringu
     * @return 
     */
    public String getTypeString() {
        return this.type.toString();
    }
    
    /**
     * Prida do panela veci
     * @param component 
     */
    protected void addToPanel(Component component) {
        this.panel.add(component);
    }

    /**
     * Vrati panel
     * @return panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    

    
    
    
    
     
}
