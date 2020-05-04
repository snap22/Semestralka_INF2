
package sk.semestralka.shakelessmidget.a.gui.main;

import java.awt.Color;
import java.awt.Font;

/**
 * Abstraktna trieda sluziaca len na ulozenie urcitych informacii potrebnych pre graficke rozhranie
 */
public abstract class BasicGui {
    /**
     * Vrati zlatu farbu
     * @return 
     */
    public static Color getGoldenColor() {
        return new Color(189, 172, 81);
    }
    
    /**
     * Vrati tmavomodru farbu
     * @return 
     */
    public static Color getDarkBlueColor() {
        return new Color(16, 49, 94);
    }
    
    /**
     * Vrati tmavosivu farbu
     * @return 
     */
    public static Color getDarkGrayColor() {
        return new Color(29, 28, 43);
    }
    
    /**
     * Vrati nazov fontu pouzivany v programe
     * @return 
     */
    public static String getFontName() {
        return "Comic Sans MS";
    }
    
    /**
     * Vrati typ fontu pouzivaneho v programe
     * @param size velkost pisma
     * @return 
     */
    public static Font getFont(int size) {
        if (size <= 0) {
            return getFont();
        }
        return new Font("Comic Sans MS", Font.PLAIN, size);
    }
    
    /**
     * Vrati typ fontu pouzivaneho v programe s predvolenou velkostou pisma 12
     * @return 
     */
    public static Font getFont() {
        return getFont(12);
    }
}
