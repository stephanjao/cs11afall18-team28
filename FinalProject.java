import java.util.Scanner;
import java.io.File;

public class FinalProject{

  public static final String FILENAME="Video_Games_Sales_as_at_22_Dec_2016.csv";
  public static int ROWS = 20000;//21293
  public static String[] name = new String[ROWS];
  public static String[] platform = new String[ROWS];
  public static String[] year = new String[ROWS];
  public static String[] genre = new String[ROWS];
  public static String[] publisher = new String[ROWS];
  public static int[] result = new int[ROWS];
  public static String currPlatform;
  public static String currGenre;
  public static String currName;


  public static void main(String[] args){
    readStaticData();
    yearSearch();
    nameSearch();
    platformSearch();
    genreSearch();
  }

  public static void readStaticData(){
    try {
        File file = new File(FILENAME);
        Scanner fileScanner = new Scanner(file);
        int row = 0;
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
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

  public static int[] yearSearch(){
    int[] temp = result;
    try {
      result = null;
      System.out.print("Start year(inclusive): ");
      String startYear = TextIO.getln();
      System.out.print("End year(inclusive): ");
      String endYear = TextIO.getln();
      for (int i=0; i<temp.length; i++){
        if (year[i].compareTo(startYear)>=0 && year[i].compareTo(endYear)<=0){
        System.out.printf("%-40s %-8s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i],publisher[i]);
        }
      }
    } catch (NullPointerException e){
        System.out.println();
    }
    return temp;
  }

  public static void nameSearch(){
    try {
      System.out.print("Name: ");
      String name1 = TextIO.getln();
      currName = name1;
      for (int i=0; i<ROWS; i++){
        if ((name[i].toLowerCase()).indexOf(name1.toLowerCase())!=-1){
          System.out.printf("%-40s %-8s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i],publisher[i]);
        }
      }
    } catch (NullPointerException e){
        System.out.println();
    }

  }

  public static void platformSearch(){
    System.out.print("2600, 3DS, DC, DS, GB, GBA, GC, GEN, N64, NES, NG, PC, PCFX, PS, PS2, PS3, PS4, PSP, PSV, SAT, SNES, Wii, WiiU, XB, XOne")
    System.out.print("Platform: ");
    String platform1 = TextIO.getln();
    currPlatform = platform1;
    for (int i=0; i<ROWS; i++){
      if (platform1.equals(platform[i])){
        System.out.printf("%-40s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i]);
      }
    }
  }

  public static void genreSearch(){
    System.out.print("Adventure, Fighting, Misc, Platform, Puzzle, Racing, Role-Playing, Shooter, Simulation, Sports, Strategy");
    System.out.print("Genre: ");
    String genre1 = TextIO.getln();
    currGenre = genre1;
    for (int i=0; i<ROWS; i++){
      if (genre1.equals(genre[i])){
        System.out.printf("%-40s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i]);
      }
    }
  }

}
