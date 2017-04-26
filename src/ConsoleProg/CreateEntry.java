package ConsoleProg;

import java.sql.SQLException;
import java.util.Scanner;

import DAOs.Categorizes.Categorizes;
import DAOs.Category.Category;
import DAOs.Comment.Comment;
import DAOs.Rating.Rating;
import DAOs.Star.Star;
import DAOs.Tag.Tag;
import DAOs.Tags.Tags;
import DAOs.Video.Video;
import DAOs.Watcher.Watcher;
import DAOs.Watches.Watches;


/**
 * Creates Entrys in tables
 * @author Uli Overdieck (s0556056)
 * @version 1.0.1
 *
 */
public class CreateEntry {
	/**
	 * @param table number for input
	 * @throws SQLException when entry is not possible or connection fails
	 */
	public static void createNewEntry(int table) throws SQLException {
        switch (table){
            case 1:
            	createEntryCategorizes(); 
                break;
            case 2:
            	createEntryCategory(); 
                break;
            case 3:
            	createEntryComment(); 
                break;
            case 4:
            	createEntryRating(); 
                break;
            case 5:
            	createEntryStar(); 
                break;
            case 6:
            	createEntryTag(); 
                break;
            case 7:
            	createEntryTags(); 
                break;
            case 8:
            	createEntryVideo(); 
                break;
            case 9:
            	createEntryWatcher(); 
                break;
            case 10:
            	createEntryWatches();
                break;
        }
        Menu.printMainMenu();
    }
	
	
	/**
	 * prompts for entry in Categorizes table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryCategorizes() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int videokey = HelpFunctions.readInt("Enter video key", sc);
		int categorykey = HelpFunctions.readInt("Enter category key", sc);
		Categorizes cat = new Categorizes(categorykey, videokey); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Category table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryCategory() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int categorykey = HelpFunctions.readInt("Enter category key", sc);
		String name = HelpFunctions.readString("Enter category name", sc);
		String previewImage = HelpFunctions.readString("Enter preview image", sc);
		Category cat = new Category(categorykey, name, previewImage); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Comment table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryComment() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int commentkey = HelpFunctions.readInt("Enter comment key", sc);
		int idvideo = HelpFunctions.readInt("Enter video key", sc);
		int idwatcher = HelpFunctions.readInt("Enter watcher key", sc);
		String name = HelpFunctions.readString("Enter content of comment", sc);
		
		Comment cat = new Comment(commentkey, idvideo, idwatcher, name); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Rating table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryRating() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int idstar = HelpFunctions.readInt("Enter star key", sc);
		int starcount1 = HelpFunctions.readInt("Enter starcount1", sc);
		int starcount2 = HelpFunctions.readInt("Enter starcount2", sc);
		int starcount3 = HelpFunctions.readInt("Enter starcount3", sc);
		int starcount4 = HelpFunctions.readInt("Enter starcount4", sc);
		int starcount5 = HelpFunctions.readInt("Enter starcount5", sc);
		int idwatcher = HelpFunctions.readInt("Enter watcher key", sc);
		Rating cat = new Rating(idstar,starcount1,starcount2,starcount3,starcount4,starcount5,idwatcher); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Star table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryStar() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int starkey = HelpFunctions.readInt("Enter star key", sc);
		String name = HelpFunctions.readString("Enter name", sc);
		String profile = HelpFunctions.readString("Enter profile", sc);
		String image = HelpFunctions.readString("Enter image", sc);
		Star cat = new Star(starkey, name, profile, image); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Tag table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryTag() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int tagid = HelpFunctions.readInt("Enter tag key", sc);
		String  name= HelpFunctions.readString("Enter name", sc);
		Tag cat = new Tag(tagid, name); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Tags table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryTags() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int tagid = HelpFunctions.readInt("Enter tag key", sc);
		int idvideo = HelpFunctions.readInt("Enter video key", sc);
		Tags cat = new Tags(tagid, idvideo); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Video table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryVideo() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int videoid = HelpFunctions.readInt("Enter video key", sc);
		int viewcount = HelpFunctions.readInt("Enter viewcount", sc);
		int idstar = HelpFunctions.readInt("Enter star key", sc);
		String  name = HelpFunctions.readString("Enter name", sc);
		String  duration = HelpFunctions.readString("Enter duration", sc);
		String  description = HelpFunctions.readString("Enter desription", sc);
		String  url = HelpFunctions.readString("Enter URl", sc);
		Video cat = new Video(videoid, viewcount, idstar, name, duration, description, url); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Watcher table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryWatcher() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int watcherid = HelpFunctions.readInt("Enter watcher key", sc);
		String  name= HelpFunctions.readString("Enter name", sc);
		Watcher cat = new Watcher(watcherid, name); 
		cat.add(); 	
	}
	
	
	/**
	 * prompts for entry in Watches table
	 * @throws SQLException when entry is not possible or connection fails
	 */
	private static void createEntryWatches() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int watcherid = HelpFunctions.readInt("Enter watcher key", sc);
		int videoid = HelpFunctions.readInt("Enter video key", sc);
		Watches cat = new Watches(watcherid, videoid);
		cat.add(); 	
	}
	
}
