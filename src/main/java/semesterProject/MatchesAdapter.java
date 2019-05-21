package semesterProject;

import java.io.IOException;
import java.io.FileNotFoundException;

public class MatchesAdapter {
   private MyFileIO fileIo;
   private String fileName;


public MatchesAdapter(String fileName) {
   this.fileIo= new MyFileIO();
   this.fileName=fileName;
}

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
