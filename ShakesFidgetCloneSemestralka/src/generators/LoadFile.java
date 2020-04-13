/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author marce
 */
public class LoadFile {
    private ArrayList<String> examples;
    private Random random;
    public LoadFile(Type type) {
        this.examples = new ArrayList<String>();
        this.random = new Random();
        String destination = "";
        
        switch (type) {
            case ENEMYNAME:
                destination = "C:/Users/marce/Documents/NetBeansProjects/Semestralka_ShakesAndFidget/ShakesFidgetCloneSemestralka/src/a_other/EnemyNamesExamples";
                break;
            case GOODSNAME:
                destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\GoodiesName";
                break;
            case ITEMSADJECTIVE:
                destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ItemAdjective";
                break;
            case OBJECTDESCRIPTION:
                destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveDescriptionExamples";
                break;
            case OBJECTNAME:
                destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\ObjectiveNameExamples";
                break;
            case WEAPONNAME:
                destination = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\WeaponName";
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
        }
        
    }
    
    public String getRandom() {
        if (this.examples.isEmpty()) {
            return "Error";
        }
        int randNum = this.random.nextInt(this.examples.size());
        return this.examples.get(randNum);
    }
}
