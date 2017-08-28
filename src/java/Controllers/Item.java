package Controllers;



/**
 *
 * @author Christian Romar Paul Serad
 */
public class Item {
    private String name;
    private String brand;
    private int price;
    private int rating;
    private int id;
    private String imageURL;

    public Item(String name, String brand, int price, int rating, int id, String imageURL) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.id = id;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
    
    public int getId(){
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }
    
    
}
