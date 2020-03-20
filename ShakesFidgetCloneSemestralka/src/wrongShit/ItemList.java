/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrongShit;

/**
 *
 * @author marce
 */
public class ItemList {
    private Item[] items;
    //nacita nazvy itemov zo suboru, resp. CELE ITEMY!
    
    public Item getItem(int index) {
        if (index >= this.items.length) {
            return null;
        }
        return this.items[index];
    }
}
