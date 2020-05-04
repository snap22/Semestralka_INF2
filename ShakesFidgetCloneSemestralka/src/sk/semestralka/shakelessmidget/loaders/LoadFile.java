
package sk.semestralka.shakelessmidget.loaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import sk.semestralka.shakelessmidget.generators.ExampleType;


/**
 *
 * Trieda ktora ma za ulohu precitat z daneho suboru rozne prvky
 */
public class LoadFile {
    private ArrayList<String> examples;
    private Random random;
    public LoadFile(ExampleType type) {
        this.examples = new ArrayList<String>();
        this.random = new Random();
        String destination = "";
        
        switch (type) {
            case ENEMYNAME:
                //destination = "C:/Users/marce/Documents/NetBeansProjects/Semestralka_ShakesAndFidget/ShakesFidgetCloneSemestralka/src/a_other/EnemyNamesExamples";
                destination = "files/EnemyNamesExamples";
                break;
            case GOODSNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\GoodiesName";
                destination = "files/GoodiesName";
                break;
            case ITEMSADJECTIVE:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ItemAdjective";
                destination = "files/ItemAdjective";
                break;
            case OBJECTDESCRIPTION:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveDescriptionExamples";
                destination = "files/ObjectiveDescriptionExamples";
                break;
            case OBJECTNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveNameExamples";
                destination = "files/ObjectiveNameExamples";
                break;
            case WEAPONNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\WeaponName";
                destination = "files/WeaponName";
                break;
            default:
                destination = "none";
        }
        
        File file = new File(destination);
        
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + destination);
        }
        if (input != null) {
            while (input.hasNextLine()) {
                this.examples.add(input.nextLine());
            }
            input.close();
        }
        
    }
    
    /**
     * Vrati nahodny retazec na zaklade toho akeho typu je trieda
     * @return 
     */
    public String getRandom() {
        if (this.examples.isEmpty()) {
            return "Error";
        }
        int randNum = this.random.nextInt(this.examples.size());
        return this.examples.get(randNum);
    }
}
