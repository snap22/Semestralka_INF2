/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;

import java.io.DataInputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;

/**
 *
 * @author marce
 */
public class MoodCreator {

    public MoodCreator() {
    }
    
    public Mood createMood(DataInputStream file) throws IOException, WrongTypeException {
        String moodName = file.readUTF().toLowerCase();
        switch (moodName) {
            case "beginner":
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
