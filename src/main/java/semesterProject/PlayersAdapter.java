package application;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * A class of PlayersAdapter object
 * 
 * @author Matey Matev
 * @version 1.0
 */
public class PlayersAdapter {
	private MyFileIO fileIo;
	private String fileName;

	/**
	 * the fileIO will be initialized
	 * 
	 * @param fileName the fileName of the matchesAdapter will be set
	 */
	public PlayersAdapter(String fileName) {
		this.fileIo = new MyFileIO();
		this.fileName = fileName;
	}

	/**
	 * @return returns PlayerList data to the program
	 */
	public PlayerList loadAllPlayers() {
		try {
			return (PlayerList) fileIo.readObjectFromFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		return new PlayerList();
	}

	/**
	 * Writes the players param to the file object of fileName
	 * 
	 * @param players the players to save in the fileName object
	 */
	public void savePlayers(PlayerList players) {
		try {
			fileIo.writeToFile(fileName, players);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}