package semesterProject;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * A class of  MatchesAdapter object
 *
 * @author Rafał Pierścieniak
 * @version 1.0
 */
public class MatchesAdapter implements Serializable {
    private MyFileIO fileIo;
    private String fileName;

    /**
     * The fileIO will be Initialized
     *
     * @param fileName the fileName of the matchesAdapter will be set
     */
    public MatchesAdapter(String fileName) {
        this.fileIo = new MyFileIO();
        this.fileName = fileName;
    }

    /**
     * @return returns MatchList data to the program
     */
    public MatchesList loadAllMatches() {
        try {
            return (MatchesList) fileIo.readObjectFromFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return new MatchesList();
    }

    /**
     * Writes the matches param to the file object of fileName
     *
     * @param matches the matches to save in the fileName object
     */
    public void saveMatches(MatchesList matches) {
        System.out.println("SAVING: " + matches);
        try {
            fileIo.writeToFile(fileName, matches);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
