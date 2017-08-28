/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class ItemScore {
    private int score;
    private int ItemId;

    public ItemScore(int score, int ItemId) {
        this.score = score;
        this.ItemId = ItemId;
    }

    public int getScore() {
        return score;
    }

    public int getItemId() {
        return ItemId;
    }
    
    
}
