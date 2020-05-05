
package sk.semestralka.shakelessmidget.a.gui.main;

import sk.semestralka.shakelessmidget.basic.Game;
import sk.semestralka.shakelessmidget.a.gui.menu.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import sk.semestralka.shakelessmidget.a.gui.listeners.ISwitchPanelListener;

/**
 * Hlavne okno pre graficke rozhranie
 */
public class MainFrame {
    
    private MenuPanel menuPanel;
    private JFrame frame;
    
    private final TemporaryPanel temp;
    private final Game game;
    
    
    /**
     * Konstruktor, spusti graficke rozhranie.
     * @param game hra
     */
    public MainFrame(Game game) {
        this.frame = new JFrame();
        this.game = game;
        this.frame.setTitle(" Shakeless Midget - Game of the year 2020");
        this.frame.setSize(800, 600);
        
        
        
        Container content = this.frame.getContentPane();
        
        this.menuPanel = new MenuPanel(this);

        this.temp = new TemporaryPanel(this.game);
        
        content.add(this.menuPanel, BorderLayout.WEST);
        content.add(this.temp, BorderLayout.CENTER);

        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);       //ak uzivatel stlaci na X vypne sa program
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                MainFrame.this.onExit();
            }
        });
        
        this.frame.setVisible(true);
        
        
        this.menuPanel.setListener(new ISwitchPanelListener() {
            @Override
            public void switchPanel(PanelType type) {
                MainFrame.this.temp.changePanel(type);
            }
        });
        
    }
    
    private void onExit() {
        this.game.save();
        System.exit(0);
    }
    
    /**
     * Getter pre hru
     * @return 
     */
    public Game getGame() {
        return this.game;
    }
    
    
    
    
}
