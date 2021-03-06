/**
  * This class implements a program that will search a database of video games and ask the user for parameter inputs.
  * Written by Yiccheng Tao, Stephan Jao, and Kayla Shepherd
  * December 6, 2018
  */

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.io.PrintWriter;

public class Testing{

  public static final String FILENAME="Video_Games_Sales_as_at_22_Dec_2016.csv";
  public static int ROWS = 16719;
  public static String[] name = new String[ROWS];
  public static String[] platform = new String[ROWS];
  public static String[] year = new String[ROWS];
  public static String[] genre = new String[ROWS];
  public static String[] publisher = new String[ROWS];
  public static int[] result = new int[ROWS];

  public static void main(String[] args){
    System.out.println("This program allows you to search for video games from a database using name, year, platform, genre, and publisher");
    readStaticData();
    toSearch();
    printFile();
  }

  public static void readStaticData(){
    //Date,Time,Transaction,Item
    try {
        File file = new File(FILENAME);

        // next create a scanner to read from the file
        Scanner fileScanner = new Scanner(file);

        // now read the entire file and print it with line numbers:
        int row = 0;
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // create a new Scanner just for this row!
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            // we read each of the four columns in this row
            name[row] = lineScanner.next();
            platform[row] = lineScanner.next();
            year[row] = lineScanner.next();
            genre[row] = lineScanner.next();
            publisher[row] = lineScanner.next();
            result[row] = row;
            row++;
        }
        fileScanner.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
  }

  public static void toSearch(){
    boolean goSearch = true;
    System.out.println("Which search do you want? (Please type name, year, platform, genre, or publisher)");
    System.out.println("Enter 0 to quit");
    while (goSearch){
      String searchkind = TextIO.getln();
      switch (searchkind){
        case "name": nameSearch(); break;
        case "year": yearSearch(); break;
        case "platform": platformSearch(); break;
        case "genre": genreSearch(); break;
        case "publisher": publisherSearch(); break;
        case "0": System.out.println("Thanks for using"); return;
        default: System.out.println("I can't recognize "+searchkind);
      }
      System.out.println("Want further search? (name, year, platform, genre, publisher)");
      System.out.println("Enter 0 to quit");
    }
  }

  public static void yearSearch(){
    int[] temp = result.clone();
    try {
      Arrays.fill(result,-1);
      System.out.println("Database contains games between 1980 and 2017");
      System.out.println("Start year(inclusive): ");
      String startyear = TextIO.getln();
      System.out.println("End year(inclusive): ");
      String endyear = TextIO.getln();
      if(Integer.parseInt(startyear) > Integer.parseInt(endyear)) {
        System.out.println("Error");
      }
      int i = 0;
      int j = 0;
      while(true){
        if (i<temp.length && temp[i]!=-1){
          if(year[temp[i]].compareTo(startyear)>=0 && year[temp[i]].compareTo(endyear)<=0){
            result[j++] = temp[i];
          }
          i++;
        } else {
          break;
        }
      }
      printResult();
    } catch (NullPointerException e){
        System.out.println();
    }
  }

  public static void nameSearch(){
    int[] temp = result.clone();
    try {
      Arrays.fill(result,-1);
      System.out.println("Name: ");
      String name1 = TextIO.getln();
      int i = 0;
      int j = 0;
      while(true){
        if (i<temp.length && temp[i]!=-1){
          if((name[temp[i]].toLowerCase()).indexOf(name1.toLowerCase())!=-1){
            result[j++] = temp[i];
          }
          i++;
        } else {
          break;
        }
      }
      printResult();
    } catch (NullPointerException e){
        System.out.println();
    }
  }

  public static void platformSearch(){
    int[] temp = result.clone();
    try {
      Arrays.fill(result,-1);
      System.out.println("Database contains games on the following platforms: 2600, 3DS, DC, DS, GB, GBA, GC, GEN, N64, NES, NG, PC, PCFX, PS, PS2, PS3, PS4, PSP, PSV, SAT, SNES, Wii, WiiU, XB, XOne");
      System.out.println("Platform: ");
      String platform1 = TextIO.getln();
      int i = 0;
      int j = 0;
      while(true){
        if (i<temp.length && temp[i]!=-1){
          if((platform[temp[i]].toLowerCase()).equals(platform1.toLowerCase())){
            result[j++] = temp[i];
          }
          i++;
        } else {
          break;
        }
      }
      printResult();
    } catch (NullPointerException e){
        System.out.println();
    }
  }

  public static void genreSearch(){
    int[] temp = result.clone();
    try {
      Arrays.fill(result,-1);
      System.out.println("Database contains games with the following genres: Adventure, Fighting, Misc, Platform, Puzzle, Racing, Role-Playing, Shooter, Simulation, Sports, Strategy");
      System.out.println("Genre: ");
      String genre1 = TextIO.getln();
      int i = 0;
      int j = 0;
      while(true){
        if (i<temp.length && temp[i]!=-1){
          if((genre[temp[i]].toLowerCase()).indexOf(genre1.toLowerCase())!=-1){
            result[j++] = temp[i];
          }
          i++;
        } else {
          break;
        }
      }
      printResult();
    } catch (NullPointerException e){
        System.out.println();
    }
  }

  public static void publisherSearch(){
    int[] temp = result.clone();
    try {
      Arrays.fill(result,-1);
      System.out.println("Publisher: ");
      String publisher1 = TextIO.getln();
      int i = 0;
      int j = 0;
      while(true){
        if (i<temp.length && temp[i]!=-1){
          if((publisher[temp[i]].toLowerCase()).indexOf(publisher1.toLowerCase())!=-1){
            result[j++] = temp[i];
          }
          i++;
        } else {
          break;
        }
      }
      printResult();
    } catch (NullPointerException e){
        System.out.println();
    }
  }

  public static void printResult(){
    int i = 0;
    try {
      int count = 0;
      while(true){
        if(i<result.length && result[i]!=-1){
          System.out.printf("%-110s %-15s %-15s %-15s %-15s%n",name[result[i]],platform[result[i]],year[result[i]],genre[result[i]],publisher[result[i]]);
          i++;
          count++;
        } else {
          break;
        }
      }
      if(count == 0) {
        System.out.println("No results");
      }
    } catch (NullPointerException e){
    }
    System.out.println();
  }

  public static void printFile(){
    int i = 0;
    try {
      System.out.println("Do you want to put the data into a .txt file? (yes or no)");
      String pfile = TextIO.getln();
      if (pfile.equals("yes")){
        System.out.println("Filename: ");
        String filename = TextIO.getln();
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        while(true){
          if(i<result.length && result[i]!=-1){
            writer.printf("%-110s %-15s %-15s %-15s %-15s%n",name[result[i]],platform[result[i]],year[result[i]],genre[result[i]],publisher[result[i]]);
            i++;
          } else {
            break;
          }
        }
        writer.close();
      }
    } catch (Exception e){
      System.out.println("Error to creat file: " +e);
    }
  }
}
