package ConsoleProg;

import DAOs.Categorizes.Categorizesable;
import DAOs.Category.Categoryable;
import DAOs.Comment.Commentable;
import DAOs.Rating.Ratingable;
import DAOs.Star.Starable;
import DAOs.Tag.Tagable;
import DAOs.Tags.Tagsable;
import DAOs.Video.Videoable;
import DAOs.Watcher.Watcherable;
import DAOs.Watchers.Watchersable;

import java.sql.SQLException;

/**
 * A class which provides a method to print out a table in the database
 */
public class PrintTable {
    /**
     * Print a certain table from the database to console
     * @param table the table number as an integer
     * @throws SQLException in case the SQL request failed
     */
    public static void printTable(int table) throws SQLException {
        switch (table){
            case 1:
                Categorizesable.getAll().forEach(System.out::println);
                break;
            case 2:
                Categoryable.getAll().forEach(System.out::println);
                break;
            case 3:
                Commentable.getAll().forEach(System.out::println);
                break;
            case 4:
                Ratingable.getAll().forEach(System.out::println);
                break;
            case 5:
                Starable.getAll().forEach(System.out::println);
                break;
            case 6:
                Tagable.getAll().forEach(System.out::println);
                break;
            case 7:
                Tagsable.getAll().forEach(System.out::println);
                break;
            case 8:
                Videoable.getAll().forEach(System.out::println);
                break;
            case 9:
                Watcherable.getAll().forEach(System.out::println);
                break;
            case 10:
                Watchersable.getAll().forEach(System.out::println);
                break;
        }
        Menu.printMainMenu();
    }
}
