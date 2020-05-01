/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.generators;

import java.io.DataInputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import sk.semestralka.shakelessmidget.player.moods.Blindfolded;
import sk.semestralka.shakelessmidget.player.moods.BloodThirsty;
import sk.semestralka.shakelessmidget.player.moods.Bursting;
import sk.semestralka.shakelessmidget.player.moods.Greedy;
import sk.semestralka.shakelessmidget.player.moods.Mood;
import sk.semestralka.shakelessmidget.player.moods.Newbie;
import sk.semestralka.shakelessmidget.player.moods.Suicidal;

/**
 * Nacita naladu zo suboru
 */
public class MoodLoader {

    /**
     * Vytvori instanciu
     */
    public MoodLoader() {
    }
    
    /**
     * Vytvori naladu podla zadaneho vstupneho parametra
     * @param file subor
     * @return nalada
     * @throws IOException
     * @throws WrongTypeException 
     */
    public Mood createMood(DataInputStream file) throws IOException, WrongTypeException {
        String moodName = file.readUTF().toLowerCase();
        switch (moodName) {
            case "newbie":
                return new Newbie();
            case "blindfolded":
                return new Blindfolded();
            case "bloodthirsty":
                return new BloodThirsty();
            case "bursting":
                return new Bursting();
            case "greedy":
                return new Greedy();
            case "suicidal":
                return new Suicidal();
            default:
                throw new WrongTypeException();
        }
    }
}
