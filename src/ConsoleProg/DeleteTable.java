package ConsoleProg;

import DAOs.Categorizes.Categorizesable;
import DAOs.Category.Categoryable;
import DAOs.Comment.Commentable;
import DAOs.Rating.Ratingable;
import DAOs.Star.Star;
import DAOs.Star.Starable;
import DAOs.Tag.Tagable;
import DAOs.Tags.Tagsable;
import DAOs.Video.Videoable;
import DAOs.Watcher.Watcherable;
import DAOs.Watchers.Watchersable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Marvin Krüger S0556109.
 */
public class DeleteTable {
    public static Scanner sc;
    public static void deleteTable(int table) throws SQLException {
        List<Integer> keys = askForKey(table);
        try{
            switch (table){
                case 1:
                    Categorizesable.delete(keys.get(0), keys.get(1));
                    break;
                case 2:
                    Categoryable.delete(keys.get(0));
                    break;
                case 3:
                    Commentable.delete(keys.get(0));
                    break;
                case 4:
                    Ratingable.delete(keys.get(0));
                    break;
                case 5:
                    Starable.delete(keys.get(0));
                    break;
                case 6:
                    Tagable.delete(keys.get(0));
                    break;
                case 7:
                    Tagsable.delete(keys.get(0), keys.get(1));
                    break;
                case 8:
                    Videoable.delete(keys.get(0));
                    break;
                case 9:
                    Watcherable.delete(keys.get(0));
                    break;
                case 10:
                    Watchersable.delete(keys.get(0), keys.get(1));
                    break;
            }
            System.out.println("Entry was deleted successful!");
            Menu.printMainMenu();
        } catch (SQLException e){
            System.out.println("Something goes wrong, did you used valid keys? ");
            Menu.selectTable(2);
        }

    }

    public static List<Integer> askForKey(int table){
        sc = new Scanner(System.in);
        List<Integer> keys = new ArrayList<Integer>();
        if(table == 1){
            keys.add(HelpFunctions.readInt("Enter a video key", sc));
            keys.add(HelpFunctions.readInt("Enter a category key", sc));
        } else if(table == 7){
            keys.add(HelpFunctions.readInt("Enter a tag key", sc));
            keys.add(HelpFunctions.readInt("Enter a video key", sc));
        } else if(table == 10){
            keys.add(HelpFunctions.readInt("Enter a watcher key", sc));
            keys.add(HelpFunctions.readInt("Enter a video key", sc));
        } else{
            keys.add(HelpFunctions.readInt("Enter a key", sc));
        }
        return keys;
    }
}
