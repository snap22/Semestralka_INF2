
package sk.semestralka.shakelessmidget.a.gui.tavern;

import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.a.gui.basic.BasicGui;
import sk.semestralka.shakelessmidget.a.gui.basic.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.basic.PanelType;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import sk.semestralka.shakelessmidget.exceptions.NoMoneyException;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda WaitPanel sluzi ako panel ktory ukazuje hracovi kolko ma cakat
 */
public final class WaitPanel extends MainPanel {

    private JButton skipButton;
    private final JProgressBar bar;
    private int timePassed;
    private final JLabel label;
    private final JLabel time;
    private final TavernPanel tav;
    private final Objective obj;
    
    /**
     * Konstruktor.Vytvori potrebne komponenty
     * @param obj uloha 
     * @param tav Tavern Panel
     * @param player
     */
    public WaitPanel(Objective obj, TavernPanel tav, Player player) {
        super(PanelType.WAIT);
        int price = 100;
        this.skipButton = new JButton("Skip");
        this.skipButton.setToolTipText(String.format("Price for skipping: %d", price));
        super.getPanel().setBackground(Color.black);
        this.timePassed = 0;
        this.tav = tav;
        this.obj = obj;
        //name
        this.label = new JLabel();
        this.label.setFont(BasicGui.getFont(50));
        this.label.setForeground(Color.WHITE);
        
        //time
        this.time = new JLabel();
        this.time.setFont(BasicGui.getFont(30));
        this.time.setForeground(Color.WHITE);
        
        super.getPanel().setLayout(new BoxLayout(super.getPanel(), BoxLayout.Y_AXIS));
        super.getPanel().add(this.label);
        super.getPanel().add(this.time);
        super.getPanel().add(Box.createRigidArea(new Dimension(0, 300)));
        
        
        this.bar = new JProgressBar(0, 100);
        super.getPanel().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        
        super.getPanel().add(this.bar);
        super.getPanel().add(this.skipButton);
        this.skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //WaitPanel.this.beginCalc();
                
                try {
                    player.removeGold(price);
                    WaitPanel.this.timePassed += 1000;
                } catch (NoMoneyException ex) {
                    JOptionPane.showMessageDialog(null, "Only the rich ones can skip", "No money", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        if (obj != null) {
            this.setup(obj); 
        }
    }

    /**
     * Pociatocny konstruktor bez ulohy
     * @param tav Tavern Panel
     * @param player hrac
     */
    public WaitPanel(TavernPanel tav, Player player) {
        this(null, tav, player);
    }

    /**
     * Nastavi ulohu
     * @param newObj nova uloha
     */
    public void setup(Objective newObj) {
        this.timePassed = 0;
        this.bar.setValue(0);
        this.bar.setMaximum(newObj.getDuration());
        this.label.setText(newObj.getName());
        this.time.setText(String.format("Duration: %d seconds", newObj.getDuration()));
        this.beginCounting();
        
    }
    
    /**
     * Zacina odpocitavanie
     */
    private void beginCounting() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                WaitPanel.this.timePassed++;
                WaitPanel.this.bar.setValue(WaitPanel.this.timePassed);
                
                
                if (WaitPanel.this.timePassed >= WaitPanel.this.bar.getMaximum()) {
                    
                    t.cancel();
                    
                    WaitPanel.this.tav.showFight();
                }
            }
        }, 0, 1000);
    }
    
}
