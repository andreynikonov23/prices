import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String price;
    private String quantity;


    public Product(String id, String name, String price, String quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        spacesId(this.id);
        spaceName(this.name);
        spacePrice(this.price);
        spaceQuantity(this.quantity);
    }
    public Product(){}

    public void setId(String id){
        this.id = id;
        spacesId(this.id);
    }
    public void setName(String name){
        this.name = name;
        spaceName(this.name);
    }
    public void setPrice(String price){
        this.price = price;
        spacePrice(this.price);
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
        spaceQuantity(this.quantity);
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getQuantity(){
        return quantity;
    }
    private void spacesId(String id){
        String str = id;
        if (str.length() < 8){
            int count = 8 - str.length();
            for (int i = 0; i < count; i++) {
                str = str + " ";
            }
        }
        if (str.length() > 8){
            str = str.substring(0, 8);
        }
        this.id = str;
    }
    private void spaceName(String name){
        String str = name;
        if (str.length() < 30){
            int count = 30 - str.length();
            for (int i = 0; i < count; i++) {
                str = str + " ";
            }
        }
        if (str.length() > 30){
            str = str.substring(0, 30);
        }
        this.name = str;
    }
    private void spacePrice(String price){
        String str = price;
        if (str.length() < 8){
            int count = 8 - str.length();
            for (int i = 0; i < count; i++) {
                str = str + " ";
            }
        }
        if (str.length() > 8){
            str = str.substring(0, 8);
        }
        this.price = str;
    }
    private void spaceQuantity(String quantity){
        String str = quantity;
        if (str.length() < 4){
            int count = 4 - str.length();
            for (int i = 0; i < count; i++) {
                str = str + " ";
            }
        }
        if (str.length() > 4){
            str = str.substring(0, 4);
        }
        this.quantity = str;
    }
    @Override
    public String toString(){
        String str = id + name + price + quantity;
        return str;
    }
    public byte[] getBytes() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(toString().getBytes());
        byte[] bytes = new byte[byteArrayInputStream.available()];
        byteArrayInputStream.read(bytes);
        return bytes;
    }
}