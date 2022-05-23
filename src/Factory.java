import java.io.*;
import java.util.stream.Stream;

public class Factory implements CRUD {
    private static Factory instance;

    private Factory(){

    }
    public Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }


    @Override
    public void serialize() {
        try(FileOutputStream outputStream = new FileOutputStream("file.bin")) {
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            Stream<Product> stream = ProductList.product.stream();
            stream.peek(product -> {
                try {
                    out.writeObject(product);
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
            Product product = (Product) in.readObject();
            ProductList.product.add(product);
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
