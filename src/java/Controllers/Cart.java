
package Controllers;

import java.util.ArrayList;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class Cart {
    ArrayList<Item> item = new ArrayList<Item>();
    
    public void addItem(Item item){
        this.item.add(item);
    }
    
    public Item getItem(int id){
        Item item = null;
        for(int i = 0; i < this.item.size(); i++){
            item = this.item.get(i);
            if((item.getId() == id)){
                break;
            }
        }
        return item;
    }
    
    public Item[] getItems(){
        Item[] item = new Item[this.item.size()];
        for(int i = 0; i < this.item.size(); i++){
            item[i] = this.item.get(i);
        }
        return item;
    }
    
    public int getSize(){
        return item.size();
    }
    
    public void removeItem(int id){
        Item item;
        for(int i = 0; i < this.item.size(); i++){
            item = this.item.get(i);
            if(item.getId() == id){
                this.item.remove(item);
                break;
            }
        }
    }
}
