package ConsoleProg;

import java.sql.SQLException;
import java.util.Scanner;

import DAOs.Categorizes.Categorizes;
import DAOs.Categorizes.Categorizesable;
import DAOs.Category.Category;
import DAOs.Category.Categoryable;
import DAOs.Comment.Comment;
import DAOs.Comment.Commentable;
import DAOs.Rating.Rating;
import DAOs.Rating.Ratingable;
import DAOs.Star.Star;
import DAOs.Star.Starable;
import DAOs.Tag.Tag;
import DAOs.Tag.Tagable;
import DAOs.Tags.Tags;
import DAOs.Tags.Tagsable;
import DAOs.Video.Video;
import DAOs.Video.Videoable;
import DAOs.Watcher.Watcher;
import DAOs.Watcher.Watcherable;
import DAOs.Watchers.Watchers;
import DAOs.Watchers.Watchersable;

public class CreateEntry {
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
            	createEntryWatchers();
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
	
	private static void createEntryCategory() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int categorykey = HelpFunctions.readInt("Enter category key", sc);
		String name = HelpFunctions.readString("Enter category name", sc);
		String previewImage = HelpFunctions.readString("Enter preview image", sc);
		Category cat = new Category(categorykey, name, previewImage); 
		cat.add(); 	
	}
	
	private static void createEntryComment() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int commentkey = HelpFunctions.readInt("Enter comment key", sc);
		int idvideo = HelpFunctions.readInt("Enter video key", sc);
		int idwatcher = HelpFunctions.readInt("Enter watcher key", sc);
		String name = HelpFunctions.readString("Enter content of comment", sc);
		
		Comment cat = new Comment(commentkey, idvideo, idwatcher, name); 
		cat.add(); 	
	}
	
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
	
	private static void createEntryStar() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int starkey = HelpFunctions.readInt("Enter star key", sc);
		String name = HelpFunctions.readString("Enter name", sc);
		String profile = HelpFunctions.readString("Enter profile", sc);
		String image = HelpFunctions.readString("Enter image", sc);
		Star cat = new Star(starkey, name, profile, image); 
		cat.add(); 	
	}
	
	private static void createEntryTag() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int tagid = HelpFunctions.readInt("Enter tag key", sc);
		String  name= HelpFunctions.readString("Enter name", sc);
		Tag cat = new Tag(tagid, name); 
		cat.add(); 	
	}
	
	private static void createEntryTags() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int tagid = HelpFunctions.readInt("Enter tag key", sc);
		int idvideo = HelpFunctions.readInt("Enter video key", sc);
		Tags cat = new Tags(tagid, idvideo); 
		cat.add(); 	
	}
	
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
	
	private static void createEntryWatcher() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int watcherid = HelpFunctions.readInt("Enter watcher key", sc);
		String  name= HelpFunctions.readString("Enter name", sc);
		Watcher cat = new Watcher(watcherid, name); 
		cat.add(); 	
	}
	
	private static void createEntryWatchers() throws SQLException{
		Scanner sc = new Scanner(System.in);
		int watcherid = HelpFunctions.readInt("Enter watcher key", sc);
		int videoid = HelpFunctions.readInt("Enter video key", sc);
		Watchers cat = new Watchers(watcherid, videoid); 
		cat.add(); 	
	}
	
}
