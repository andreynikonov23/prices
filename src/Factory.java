import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Factory implements CRUD {
    private static Factory instance;
    private final int sizeFile;

    {
        try {
            sizeFile = (int) Files.size(Path.of("file.bin"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Factory(){

    }
    public static Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }


    @Override
    public void serialize() {
        try(FileOutputStream outputStream = new FileOutputStream("file.bin")) {
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            ProductList.products.forEach(x -> {
                try {
                    out.writeObject(x);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deserialize() {
        try(FileInputStream inputStream = new FileInputStream("file.bin")) {
            ObjectInputStream in = new ObjectInputStream(inputStream);
            while (inputStream.available() > 0){
                Product product = (Product) in.readObject();
                ProductList.products.add(product);
            }
            toTxt();

        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name, String cost, String quantity) {
        Product product = new Product(String.valueOf(ProductList.products.size() + 1), name, cost, quantity);
        ProductList.products.add(product);
        serialize();
        toTxt();
    }

    @Override
    public void update(String id, String name, String price, String quantity) {
        ProductList.products.forEach(product -> {
            if (product.getId().contains(id)){
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
            }
        });
        serialize();
        toTxt();
    }

    @Override
    public void delete(String id) {
        int index = 0;
        for (int i = 0; i < ProductList.products.size(); i++) {
            if (ProductList.products.get(i).getId().contains(id)){
                ProductList.products.remove(i);
                index = i;
                i--;
            }
        }
        for (int i = index; i < ProductList.products.size(); i++) {
            int countId = Integer.parseInt(ProductList.products.get(i).getId().trim()) - 1;
            ProductList.products.get(i).setId(String.valueOf(countId));
        }
        serialize();
        toTxt();
    }

    @Override
    public void toTxt() {
        try(FileWriter writer = new FileWriter("file.txt")) {
            ProductList.products.forEach(x -> {
                try {
                    writer.write(x.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
