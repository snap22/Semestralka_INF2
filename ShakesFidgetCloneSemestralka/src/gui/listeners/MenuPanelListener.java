/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.listeners;

import gui.panels.TemporaryPanel;
import gui.panels.mainPanels.PanelType;


/**
 * Trieda ktora ma za ulohu menit dany temporary panel v mainframe
 * Je to vlastne konkretna implementacia interface. Dovod vzniku tejto triedy je ten,
 * ze v anonymous classe sa neda pristupovat k atributom triedy, v ktorej anonymouc class
 * vznikol s prikazom "this" a vyskakoval check style error
 * @author marce
 */
public class MenuPanelListener implements IMenuPanelListener {

    private final TemporaryPanel temp;

    public MenuPanelListener(TemporaryPanel temp) {
        this.temp = temp;   
    }

    /**
     * Nastavi panel hracovi taky, na aky button klikneme
     * @param type 
     */
    @Override
    public void changePanel(PanelType type) {
        if (this.temp == null) {
            return;
        }
        this.temp.changePanel(type);
    }
    
}
