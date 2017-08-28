
package Controllers;

import java.util.ArrayList;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class ItemSearchContainer {
    private ItemScore[] itemScore;
    
    public void search(Item[] item, String keyword){
        ItemScore[] tempItemScore = findScore(item, keyword);
        itemScore = sortScore(tempItemScore);
    }
    
    public ItemScore[] getItemScore(){
        return itemScore;
    }
    
    private ItemScore[] findScore(Item[] item, String keyword){
        ArrayList<ItemScore> tempItemScore = new ArrayList<ItemScore>();
        for(int i = 0; i < item.length; i++){
            int nameScore = 0;
            int otherScore = 0;
            int total = 0;
            if(item[i].getName().toLowerCase().indexOf(keyword.toLowerCase()) != -1){
                nameScore += 1;
                int sentenceCut = item[i].getName().toLowerCase().indexOf(keyword.toLowerCase());
                while(item[i].getName().toLowerCase().substring(sentenceCut + keyword.length()).indexOf(keyword) != -1){
                    nameScore += 1;
                    sentenceCut = item[i].getName().toLowerCase().substring(sentenceCut + keyword.length()).indexOf(keyword);
                }   
            }
            if(item[i].getBrand().toLowerCase().indexOf(keyword.toLowerCase()) != -1){
                otherScore += 1;
                int sentenceCut = item[i].getBrand().toLowerCase().indexOf(keyword.toLowerCase());
                while(item[i].getBrand().toLowerCase().substring(sentenceCut + keyword.length()).indexOf(keyword) != -1){
                    otherScore += 1;
                    sentenceCut = item[i].getBrand().toLowerCase().substring(sentenceCut + keyword.length()).indexOf(keyword);
                }   
            }
            total = (2 * nameScore) + otherScore;
            if(total > 0){
                tempItemScore.add(new ItemScore(total, item[i].getId()));
            }
        }
        return tempItemScore.toArray(new ItemScore[tempItemScore.size()]);
    }
    
    private ItemScore[] sortScore(ItemScore[] tempItemScore){
        ItemScore[] sortedItemScore = new ItemScore[tempItemScore.length];
        for(int i = 0; i < sortedItemScore.length; i++){
            ItemScore itemScore = null;
            for(int x = 0; x < tempItemScore.length; x++){
                if(itemScore == null){
                    boolean sameObject = false;
                    for(int y = 0; y < sortedItemScore.length; y++){
                        if(sortedItemScore[y] == tempItemScore[x]){
                            sameObject = true;
                            break;
                        }
                    }
                    if(!sameObject){
                        itemScore = tempItemScore[x];
                    }
                }
                else if(itemScore.getScore() < tempItemScore[x].getScore()){
                    boolean sameObject = false;
                    for(int y = 0; y < sortedItemScore.length; y++){
                        if(sortedItemScore[y] == tempItemScore[x]){
                            sameObject = true;
                            break;
                        }
                    }
                    if(!sameObject){
                        itemScore = tempItemScore[x];
                    }
                }
            }
            sortedItemScore[i] = itemScore;
        }
        return sortedItemScore;
    }
    
    
}
