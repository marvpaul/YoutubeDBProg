package ConsoleProg;

import DAOs.Category.Categoryable;
import DAOs.DBConnection;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * A class which provides some necessary functions to offer a console menu
 * to manage the given database
 */
public class Menu {
    public static String[] tables = {"Categorizes", "Category", "Comment", "Rating", "Star", "Tag", "Tags", "Video", "Watcher", "Watchers"};
    public static Scanner sc;

    public static void main(String[] args) throws SQLException {
        System.out.println("Establish connection to database. This may take a while ...");
        DBConnection.createConnection();
        Categoryable.delete(1);
        printMainMenu();
    }
    public static void printMainMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Read table");
        System.out.println("2 - Delete table entry");
        System.out.println("3 - Add entry");
        int option = HelpFunctions.readInt("Choose an option:", sc);

        if(option == 1){
            selectTable(1);
        } else if(option == 2) {
            selectTable(2);
        } else if(option == 3) {
            selectTable(3);
        } else{
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
        System.out.println("Choose a table:");
        for (int i = 0; i < tables.length; i++) {
            System.out.println((i+1) + " - " + tables[i]);
        }
        int option = HelpFunctions.readInt("Choose an option:", sc);
        if(option > 0 && option <= tables.length){
            if(task == 1){
                PrintTable.printTable(option);
            } else if(task == 2){
                DeleteTable.deleteTable(option);
            } else if(task == 3){
                CreateEntry.createNewEntry(option);
            }

        } else{
            System.out.println("Wasn't a valid option, try again!");
            selectTable(task);
        }
    }


}
