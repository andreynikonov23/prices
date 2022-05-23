import java.util.Scanner;

public class Main {
    private static String command;
    private static String id;
    private static String name;
    private static String cost;
    private static String quantity;
    public static void main(String[] args) {
        getCommand();
    }
    public static void getCommand(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("C:\\Users\\xxxke\\IdeaProjects\\prices\\~main:  ");
        while (true){
            String value = scanner.nextLine();
            if (value.equals("exit")){
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
            } else if (command.equals("-d")) {

            }
        }
    }
}