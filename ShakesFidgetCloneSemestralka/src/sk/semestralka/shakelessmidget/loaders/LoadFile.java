/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                destination = "filesForGenerators/EnemyNamesExamples";
                break;
            case GOODSNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\GoodiesName";
                destination = "filesForGenerators/GoodiesName";
                break;
            case ITEMSADJECTIVE:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ItemAdjective";
                destination = "filesForGenerators/ItemAdjective";
                break;
            case OBJECTDESCRIPTION:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveDescriptionExamples";
                destination = "filesForGenerators/ObjectiveDescriptionExamples";
                break;
            case OBJECTNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveNameExamples";
                destination = "filesForGenerators/ObjectiveNameExamples";
                break;
            case WEAPONNAME:
                //destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\WeaponName";
                destination = "filesForGenerators/WeaponName";
                break;
            default:
                throw new AssertionError();
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
