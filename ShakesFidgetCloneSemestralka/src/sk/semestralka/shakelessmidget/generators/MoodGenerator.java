/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.generators;

import java.util.Random;
import sk.semestralka.shakelessmidget.player.moods.Blindfolded;
import sk.semestralka.shakelessmidget.player.moods.BloodThirsty;
import sk.semestralka.shakelessmidget.player.moods.Bursting;
import sk.semestralka.shakelessmidget.player.moods.Greedy;
import sk.semestralka.shakelessmidget.player.moods.Mood;
import sk.semestralka.shakelessmidget.player.moods.Newbie;
import sk.semestralka.shakelessmidget.player.moods.Suicidal;

/**
 * Trieda sluzi na vytvaranie nahodnych nálad
 */
public class MoodGenerator {

    private final Random random;

    /**
     * Nastavi pociatocne hodnoty
     */
    public MoodGenerator() {
        this.random = new Random();
    }
    
    /**
     * Vytvori nahodnu naladu a vrati ju
     * @return nálada
     */
    public Mood generateRandomMood() {
        int num = this.random.nextInt(10);
        switch (num) {
            case 0:
                return new Blindfolded();
            case 1:
                return new BloodThirsty();
            case 2:
                return new Bursting();
            case 3:
                return new Greedy();
            case 4:
                return new Suicidal();
            default:
                return new Newbie();
        }
    }
}
