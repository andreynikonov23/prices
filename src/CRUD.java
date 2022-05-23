import java.io.IOException;

public interface CRUD {
    void serialize();
    void deserialize();
    void add(String name, String price, String quantity);
    void update(String id, String name, String price, String quantity);
    void delete(String id);
    void toTxt() throws IOException;
}
