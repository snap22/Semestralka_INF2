
package sk.semestralka.shakelessmidget.a.gui.tavern;


import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import sk.semestralka.shakelessmidget.a.gui.main.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import sk.semestralka.shakelessmidget.adventure.Mission;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.creatures.Player;


/**
 * Trieda FightPanel sluzi na zobrazenie suboja medzi hracom a nepriatelom
 */
public class FightPanel extends MainPanel {

    private Objective obj;
    private final Player player;
    private final TavernPanel tavern;
    private final JTextArea text;
    
    private Mission mission;

    /**
     * Konstruktor ktory zobrazi priebeh boja
     * @param player hrac
     * @param obj uloha ktoru ma hrac splnit
     * @param tav Tavern Panel
     */
    public FightPanel(Player player, Objective obj, TavernPanel tav) {
        super(PanelType.FIGHT);
        super.getPanel().setBackground(Color.black);
        super.getPanel().setLayout(new BorderLayout());
        this.player = player;
        this.obj = obj;
        this.tavern = tav;

        JButton change = new JButton("Return back");
        change.setFont(BasicGui.getFont(20));
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        
        super.getPanel().add(change, BorderLayout.SOUTH);
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tav.showMissions();
            }
        });
        this.text = new JTextArea();
        JScrollPane scroll = new JScrollPane(this.text);

        super.getPanel().add(scroll, BorderLayout.CENTER);

        this.text.setFont(BasicGui.getFont(15));
        this.text.setEditable(false);
        
    }

    /**
     * Pociatocny konstruktor
     * @param player hrac
     * @param tav Tavern Panel
     */
    public FightPanel(Player player, TavernPanel tav) {
        this(player, null, tav);
    }

    /**
     * Prida do priebehu suboja text
     * @param newText 
     */
    public void appendText(String newText) {
        this.text.append(newText);
    }
    
    /**
     * Vycisty priebeh suboja
     */
    public void clear() {
        this.text.setText("");
    }
    
    /**
     * Nastavi ulohu podla zadaneho parametra
     * @param obj 
     */
    public void setup(Objective obj) {
        if (obj == null) {
            return;
        }
        this.clear();
        this.obj = obj;
        this.mission = new Mission(obj, this.player, this);
        this.mission.start();
    }

}
