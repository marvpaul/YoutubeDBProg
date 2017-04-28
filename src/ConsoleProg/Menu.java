package ConsoleProg;


import DAOs.DBConnection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * A class which provides some necessary functions to offer a console menu
 * to manage the given database
 */
public class Menu {
    public static String[] tables = {"Categorizes", "Category", "Comment", "Rating", "Star", "Tag", "Tags", "Video", "Watcher", "Watches"};
    public static Scanner sc;
    //TODO: in Comment objekt Attribut name umbenennen
    public static void main(String[] args) throws SQLException {
        System.out.println("Establish connection to database. This may take a while ...");
        DBConnection.createConnection();
        printMainMenu();
    }

    /**
     * Method which handles the user interaction for main menu and print out this menu
     * @throws SQLException in case the SQL request for getting tables content failed
     */
    public static void printMainMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Read table");
        System.out.println("2 - Delete table entry");
        System.out.println("3 - Add entry");
        System.out.println("4 - Show ");
        System.out.println("5 - Exit ");
        int option = HelpFunctions.readInt("Choose an option:", sc);

        if(option == 1){
            selectTable(1);
        } else if(option == 2) {
            selectTable(2);
        } else if(option == 3) {
            try{
                selectTable(3);
            } catch (Exception e){
                System.out.println("Creating entry wasn't successful.");
                printMainMenu();
            }
        } else if(option == 4) {
            selectTable(4);
        } else if(option == 5) {
            DBConnection.closeConnection();
            System.exit(0);
        }else{
            System.out.println("Wasn't a valid option, try again!");
            printMainMenu();
        }
    }

    /**
     * Print a dialogue for choosing a certain table which will be displayed to the console
     * @throws SQLException in case the SQL request for getting tables content failed
     */
    public static void selectTable(int task) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("0 - Main Menu");
        for (int i = 0; i < tables.length; i++) {
            System.out.println((i+1) + " - " + tables[i]);
        }
        int option = HelpFunctions.readInt("Choose a table", sc);
        if(option > 0 && option <= tables.length){
            if(task == 1){
                PrintTable.printTable(option);
            } else if(task == 2){
                DeleteTable.deleteTable(option);
            } else if(task == 3){
                CreateEntry.createNewEntry(option);
            }else if(task == 4){
                GoThroughEntries.goThrough(option);
            }

        } else if (option == 0) {
            printMainMenu();
        } else{
            System.out.println("Wasn't a valid option, try again!");
            selectTable(task);
        }
    }


}
