import java.util.Scanner;

public class Main {
    private static String command;
    private static String id;
    private static String name;
    private static String cost;
    private static String quantity;
    private static Factory factory;
    public static void main(String[] args) {
        massage();
        factory = Factory.getInstance();
        factory.deserialize();
        getCommand();
    }
    public static void getCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("C:\\Users\\xxxke\\IdeaProjects\\prices\\~main:  ");
            String value = scanner.nextLine();
            if (value.equals("exit")) {
                break;
            }
            command = value.substring(0, 2).trim();
            if (command.equals("-c")) {
                int lastSpaceIndex = value.lastIndexOf(" ");
                quantity = value.substring(lastSpaceIndex).trim();
                int spaceCostIndex = value.lastIndexOf(" ", lastSpaceIndex - 1);
                cost = value.substring(spaceCostIndex, lastSpaceIndex).trim();
                name = value.substring(3, spaceCostIndex);
                System.out.println(command + "\n" + name + "\n" + cost + "\n" + quantity);
                factory.add(name, cost, quantity);
            } else if (command.equals("-u")) {
                int idSpaceIndex = value.indexOf(" ", 3);
                id = value.substring(3, idSpaceIndex);
                System.out.println(idSpaceIndex);
                int lastSpaceIndex = value.lastIndexOf(" ");
                quantity = value.substring(lastSpaceIndex).trim();
                int spaceCostIndex = value.lastIndexOf(" ", lastSpaceIndex - 1);
                cost = value.substring(spaceCostIndex, lastSpaceIndex).trim();
                name = value.substring(idSpaceIndex + 1, spaceCostIndex);
                System.out.println(command + "\n" + id + "\n" + name + "\n" + cost + "\n" + quantity);
                factory.update(id, name, cost, quantity);
            } else if (command.equals("-d")) {
                id = value.substring(3);
                System.out.println(id);
                factory.delete(id);
            }
            command = "";
            id = "";
            name = "";
            cost = "";
            quantity = "";
        }
    }
    public static void massage(){
        System.out.println("  Hi, this is the \"Prices\" project.");
        System.out.println("This little program stores in file.txt data about goods, their prices and quantity.");
        System.out.println("Data can be added, deleted, and modified. To add it, use the '-c' command, then write down the name, price and quantity.\n" +
                "To modified, use the '-u' command, then write down the id of the field where you need to change the data and new data.\n" +
                "To delete, use the '-d' command, then enter the id of the field to delete.");
        System.out.println("Example:");
        System.out.println();
        System.out.println("        -c name price quantity");
        System.out.println("        -u id name price quantity");
        System.out.println("        -d id");
        System.out.println();
        System.out.println();
        System.out.println("Good luck!!!");
        System.out.println();
    }
}