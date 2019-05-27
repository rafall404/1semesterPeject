package semesterProject;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * A class of  MatchesAdapter object
 * @author Matey Matev
 * @version 1.0
 */
public class MatchesAdapter {
   private MyFileIO fileIo;
   private String fileName;

   /**
    * The fileIO will be Initialized
    * @param fileName the fileName of the matchesAdapter will be set
    */
public MatchesAdapter(String fileName) {
   this.fileIo= new MyFileIO();
   this.fileName=fileName;
}

/**
 * @return returns MatchList data to the program
 */
public MatchesList loadAllMatches() {
   MatchesList matches = null;
   
   try {
      matches = (MatchesList) fileIo.readObjectFromFile(fileName);
   }catch(FileNotFoundException e) {
      System.out.println("File not found");
   }catch(IOException e) {
      System.out.println("IO Error reading file");
   }catch(ClassNotFoundException e) {
      System.out.println("Class Not Found");
   }
   return matches;
}

/**
 * Writes the matches param to the file object of fileName 
 * @param matches the matches to save in the fileName object
 */
public void savePlayers(MatchesList matches) {
   try
   {
   fileIo.writeToFile(fileName, matches);
   }
   catch (FileNotFoundException e)
   {
   System.out.println("File not found");
   }
   catch (IOException e)
   {
   System.out.println("IO Error writing to file");
   }
}
}
