
package Controllers;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class test {
    public static void main(String[] args) {
        Item[] item = new Item[7];
        item[0] = new Item("Shampoo","Shinez",19,2,1,"images/itemimages/phone.jpg");
        item[1] = new Item("Ultrabook","Apple",300,4,2,"images/itemimages/phone.jpg");
        item[2] = new Item("Phone","Samsung",100,5,3,"images/itemimages/phone.jpg");
        item[3] = new Item("Clothes","AE",10,1,4,"images/itemimages/phone.jpg");
        item[4] = new Item("TV","Sony",400,2,5,"images/itemimages/phone.jpg");
        item[5] = new Item("VideoGame","Ubi",60,3,6,"images/itemimages/phone.jpg");
        item[6] = new Item("Phone2","Apple",100,5,7,"images/itemimages/phone.jpg");
        
        ItemSearchContainer itemsearch = new ItemSearchContainer();
        itemsearch.search(item, "Phone");
        
        
        ItemScore[] score = itemsearch.getItemScore();
        
        System.out.println(score.length);
        for(int i = 0; i < score.length; i++){
            System.out.println(score[i].getScore());
        }
                
                
    }
}
