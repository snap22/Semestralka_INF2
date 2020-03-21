/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.equippable;

import basic.Chance;
import items.Item2;
import items.ItemRarity;


public abstract class Equipment extends Item2 {

    private int bonusHealth;
    private int bonusDamage;
    private int bonusArmor;
    private int levelRequired;
    private int goldValue;

    public Equipment(String name, ItemRarity rarity, int damage, int bonusHealth, int armor, int levelRequired) {
        super(name, rarity);
        this.levelRequired = levelRequired;
        this.nastavHodnoty();
        
    }

    public int getBonusHealth() {
        return this.bonusHealth;
    }

    public int getBonusDamage() {
        return this.bonusDamage;
    }

    public int getBonusArmor() {
        return this.bonusArmor;
    }

    public int getLevelRequired() {
        return this.levelRequired;
    }
    
    @Override
    public abstract String toString();

    @Override
    public int getGoldValue() {
        return this.goldValue;
    }
    
    /**
     * Nastavi hodnoty podla toho, aka je vzacnost a aky je potrebny level  na to aby bol item equipnuty
     */
    private void nastavHodnoty() {
        if (this.levelRequired <= 1) {
            this.bonusArmor = 1;
            this.bonusDamage = 1;
            this.bonusHealth = 1;
            this.goldValue = 0;
            return;
        }
        
        int min = this.levelRequired;
        int max = min + 5;
        
        //nastavi pocitatocne hodnoty itemu podla level required
        int dmg = Chance.random(min, max);
        int armor = Chance.random(min, max);
        int hp = Chance.random(min, max);
        int gold = Chance.random(0, max);
        
        if (this.bonusArmor == 0 || this.bonusHealth == 0) {
            armor = 0;
            hp = 0;
        } else {
            dmg = 0;
        }
        
        switch (super.getRarity()) {   
            case COMMON:
                break;
            case UNCOMMON:
                if (this.levelRequired < 5) {
                    break;
                }
                dmg *= 2;
                armor *= 2;
                hp *= 2;
                gold *= 2;
                break;
            case RARE:
                if (this.levelRequired < 10) {
                    break;
                }
                dmg *= 4;
                armor *= 4;
                hp *= 4;
                gold *= 4;
                break;
            case EPIC:
                if (this.levelRequired < 50) {
                    break;
                }
                dmg *= 8;
                armor *= 8;
                hp *= 8;
                gold *= 8;
                break;
            default:
        }
        this.bonusArmor = armor;
        this.bonusDamage = dmg;
        this.bonusHealth = hp;
        this.goldValue = gold;
    }


    
    
    
    
}
