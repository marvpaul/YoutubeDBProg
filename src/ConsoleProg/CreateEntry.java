package ConsoleProg;

import java.sql.SQLException;
import java.util.Scanner;

import DAOs.Categorizes.Categorizes;
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

public class CreateEntry {
	public static void createNewEntry(int table) throws SQLException {
        switch (table){
            case 1:
            	createEntryCategorizes(); 
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
	
	private static void createEntryCategorizes() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int videokey = HelpFunctions.readInt("Enter video key", sc);
		int categorykey = HelpFunctions.readInt("Enter category key", sc);
		Categorizes cat = new Categorizes(categorykey, videokey); 
		cat.add(); 	
	}
}
