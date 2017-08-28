package Controllers;



/**
 *
 * @author Christian Romar Paul Serad
 */
public class ItemContainer {
    
    private Item[] item = new Item[10];
    
    public Item[] generate(){
        item[0] = new Item("Headphone","Bose",19,2,1,"images/itemimages/headphone.jpg");
        item[1] = new Item("Ultrabook","Dell",300,4,2,"images/itemimages/ultrabook.jpg");
        item[2] = new Item("Phone","Apple",100,5,3,"images/itemimages/phone.jpg");
        item[3] = new Item("Virtual Reality","Samsung",10,1,4,"images/itemimages/virtualreality.jpg");
        item[4] = new Item("TV","Sony",400,2,5,"images/itemimages/tv.jpg");
        item[5] = new Item("VideoGame","Rockstar",60,3,6,"images/itemimages/videogame.jpg");
        item[6] = new Item("Phone2","Samsung",100,5,7,"images/itemimages/phone2.jpg");
        item[7] = new Item("Watch","apple",100,5,8,"images/itemimages/watch.png");
        item[8] = new Item("Drone","DJI",100,5,9,"images/itemimages/drone.jpg");
        item[9] = new Item("Console","Microsoft",100,5,10,"images/itemimages/console.jpg");
        
        return item;
    }
    
    public Item[] getItems(){
        return item;
    }
    
    public Item getItem(int id){
        int number = 0;
        for(int i = 0; i < item.length; i++){
            if(item[i].getId() == id){
                number = i;
                break;
            }
        }
        return item[number];
    }
}
