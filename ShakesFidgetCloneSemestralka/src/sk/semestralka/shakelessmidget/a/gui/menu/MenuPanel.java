
package sk.semestralka.shakelessmidget.a.gui.menu;

import sk.semestralka.shakelessmidget.a.gui.basic.MainFrame;
import sk.semestralka.shakelessmidget.a.gui.basic.PanelType;
import java.awt.Color;

import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.a.gui.listeners.ISwitchPanelListener;

/**
 *
 *  Trieda MenuPanel obsahujuca hlavne buttony sluziace pre zmenu okna
 */
public class MenuPanel {

    private Dimension size;
    private HashMap<String, MenuButton> buttons;
    private final MainFrame frame;
    private final LowerButtonsPanel lowPanel;
    
    private ISwitchPanelListener listener;
    
    private JPanel panel;
    /**
     * Konstruktor, zobrazi panel
     * @param frame
     */
    public MenuPanel(MainFrame frame) {
        this.panel = new JPanel();
        this.listener = null;
        this.frame = frame;
        this.buttons = new HashMap<String, MenuButton>();

        this.size = this.panel.getPreferredSize();
        this.size.width = 200;
        
        this.panel.setBackground(new Color(26, 26, 53));
        this.panel.setPreferredSize(this.size);

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        
        
        
        this.createGap(10);
        
        // main game buttony
        this.createMenuButton("Tavern", PanelType.TAVERN);
        this.createMenuButton("Shop", PanelType.SHOP);
        this.createMenuButton("Hero", PanelType.HERO);
        //this.createMenuButton("Dungeons");
        
        this.createGap(270);
        this.lowPanel = new LowerButtonsPanel(this.frame.getGame()); 
        this.panel.add(this.lowPanel.getPanel());
        
    }
    
    /**
     * Absolutely not fucking sure about this
     * @param listener 
     */
    public void setListener(ISwitchPanelListener listener) {
        for (MenuButton button : this.buttons.values()) {
            button.setListener(listener);
        }
    }
    
    /**
     * Vrati panel
     * @return panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    /**
     * Vytvori priestor za poslednym buttonom
     * @param height 
     */
    private void createGap(int height) {
        if (height <= 0) {
            return;
        }
        this.panel.add(Box.createRigidArea(new Dimension(0, height)));
    }
    
    /**
     * Vytvori button so zadanym textom
     * @param text 
     */
    private void createMenuButton(String text, PanelType type) {
        MenuButton newButton = new MenuButton(text, this.size, type);

        this.panel.add(newButton.getButton());
        this.buttons.put(newButton.getButton().getText(), newButton);
        this.createGap(5);
        
                
    }



    
}
