package ConsoleProg;

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
import DAOs.Watches.Watches;
import DAOs.Watches.Watchesable;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Marvin Krüger S0556109.
 */
public class GoThroughEntries {
    public static void goThrough(int table) throws SQLException {
        switch (table){
            case 1:
                List<Categorizes> categorizes = Categorizesable.getAll();
                iterateThroughEntries(categorizes, true, 0, true);
                break;
            case 2:
                List<Category> categories = Categoryable.getAll();
                iterateThroughEntries(categories, true, 0, true);
                break;
            case 3:
                List<Comment> comment = Commentable.getAll();
                iterateThroughEntries(comment, true, 0, true);
                break;
            case 4:
                List<Rating> rating = Ratingable.getAll();
                iterateThroughEntries(rating, true, 0, true);
                break;
            case 5:
                List<Star> star = Starable.getAll();
                iterateThroughEntries(star, true, 0, true);
                break;
            case 6:
                List<Tag> tag = Tagable.getAll();
                iterateThroughEntries(tag, true, 0, true);
                break;
            case 7:
                List<Tags> tags = Tagsable.getAll();
                iterateThroughEntries(tags, true, 0, true);
                break;
            case 8:
                List<Video> video = Videoable.getAll();
                iterateThroughEntries(video, true, 0, true);
                break;
            case 9:
                List<Watcher> watcher = Watcherable.getAll();
                iterateThroughEntries(watcher, true, 0, true);
                break;
            case 10:
                List<Watches> watchers = Watchesable.getAll();
                iterateThroughEntries(watchers, true, 0, true);
                break;
        }
        Menu.printMainMenu();
    }

    private static <T> void iterateThroughEntries(List<T> list, boolean first, int key, boolean next) throws SQLException {
        if(list.size() != 0){
            if(first){
                System.out.println(list.get(0));
                String statementString = checkIfNext();
                while ((statementString.equals("n")) && (statementString.equals("p")) && (statementString.equals("1"))){
                    System.out.println("Please enter a valid statement");
                    statementString = checkIfNext();
                }
                if(statementString.equals("n")){
                    iterateThroughEntries(list, false, 0, true);
                } else if(statementString.equals("p")){
                    iterateThroughEntries(list, false, 0, false);
                } else{
                    Menu.printMainMenu();
                }
            } else{
                int nextKey = printElem(list, key, next);
                String statementString = checkIfNext();
                while ((statementString.equals("n")) && (statementString.equals("p")) && (statementString.equals("1"))){

                    System.out.println("Please enter a valid statement");
                    statementString = checkIfNext();
                }
                if(statementString.equals("n")){
                    iterateThroughEntries(list, false, nextKey, true);
                } else if(statementString.equals("p")){
                    iterateThroughEntries(list, false, nextKey, false);
                } else{
                    Menu.printMainMenu();
                }
            }
        } else{
            System.out.println("No entries were found ");
            Menu.printMainMenu();
        }

    }

    private static <T> int printElem(List<T> list, int key, boolean next){
        if(next){
            if(list.size()-1 >= key+1){
                System.out.println(list.get(key+1));
                return key+1;
            } else{
                System.out.println(list.get(0));
                return 0;
            }
        } else{
            if(0 <= key-1){
                System.out.println(list.get(key-1));
                return key-1;
            } else{
                System.out.println(list.get(list.size()-1));
                return list.size()-1;
            }
        }
    }
    private static String checkIfNext(){
        Scanner sc = new Scanner(System.in);
        String statement = HelpFunctions.readString("Enter n to see next entry, p for previous, 1 for menu", sc);
        System.out.println(statement);
       if(statement.equals("n")){
           return statement;
       } else if(statement.equals("p")){
           return statement;
       } else if(statement.equals("1")){
           return statement;
       }
       return "Failed";
    }
}
