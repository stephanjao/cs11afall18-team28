import java.util.Scanner;
import java.io.File;

public class project{

  public static final String FILENAME="Video_Games_Sales_as_at_22_Dec_2016.csv";//"BreadBasket_DMS.csv";
  public static int ROWS = 20000;//21293
  public static String[] name = new String[ROWS];
  public static String[] platform = new String[ROWS];
  public static String[] year = new String[ROWS];
  public static String[] genre = new String[ROWS];
  public static String[] publisher = new String[ROWS];
  public static int[] result = new int[ROWS];

  public static void main(String[] args){
    readStaticData();
    yearSearch();
    nameSearch();
    platformSearch();
    genreSearch();
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
    System.out.print("Platform: ");
    String platform1 = TextIO.getln();
    for (int i=0; i<ROWS; i++){
      if (platform1.equals(platform[i])){
        System.out.printf("%-40s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i]);
      }
    }
  }

  public static void genreSearch(){
    System.out.print("Genre: ");
    String genre1 = TextIO.getln();
    for (int i=0; i<ROWS; i++){
      if (genre1.equals(genre[i])){
        System.out.printf("%-40s %-8s %-8s %-8s%n",name[i],platform[i],year[i],genre[i]);
      }
    }
  }

}
