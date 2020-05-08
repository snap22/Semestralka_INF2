
package sk.semestralka.shakelessmidget.loaders;

import sk.semestralka.shakelessmidget.generators.ExampleType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * Trieda ktora ma za ulohu precitat z daneho suboru rozne prvky
 */
public class LoadFile {
    private ArrayList<String> examples;
    private Random random;
    
    /**
     * Nastavi pociatocne hodnoty
     * @param type typ suboru
     */
    public LoadFile(ExampleType type) {
        this.examples = new ArrayList<String>();
        this.random = new Random();
        String destination = "";
        
        switch (type) {
            case ENEMYNAME:
                destination = "files/EnemyNamesExamples";
                break;
            case GOODSNAME:
                destination = "files/GoodiesName";
                break;
            case ITEMSADJECTIVE:
                destination = "files/ItemAdjective";
                break;
            case OBJECTDESCRIPTION:
                destination = "files/ObjectiveDescriptionExamples";
                break;
            case OBJECTNAME:
                destination = "files/ObjectiveNameExamples";
                break;
            case WEAPONNAME:
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
     * @return retazec
     */
    public String getRandom() {
        if (this.examples.isEmpty()) {
            return "Error";
        }
        int randNum = this.random.nextInt(this.examples.size());
        return this.examples.get(randNum);
    }
}
