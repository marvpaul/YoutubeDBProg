package ConsoleProg;


import java.util.Scanner;

/**
 * A class which provides some helpful function to read the users input
 */
public class HelpFunctions {
    /**
     * Read a string from console
     * @param message a message that will inform the user about the value to enter
     * @param sc the scanner which scans the console for the next String
     * @return the entered string
     */
    public static String readString(String message, Scanner sc){
        System.out.println(message);

        return sc.nextLine();
    }

    /**
     * Read a integer from console
     * @param message a message that will inform the user about the value to enter
     * @param sc the scanner which scans the console for the next int
     * @return the entered int
     */
    public static int readInt(String message, Scanner sc){
        System.out.println(message);


        String value = sc.nextLine();
        try{
            return Integer.parseInt(value);
        } catch (Exception e){
            System.out.println("Wasn't a valid entry! Try again.");
            readInt(message, sc);
        }
        return -1;

    }
}
