package semesterProject;

import java.io.IOException;
import java.io.FileNotFoundException;

public class PlayersAdapter {
	private MyFileIO fileIo;
	private String fileName;


public PlayersAdapter(String fileName) {
	this.fileIo= new MyFileIO();
	this.fileName=fileName;
}

public PlayerList loadAllPlayers() {
	PlayerList players = null;
	
	try {
		players = (PlayerList) fileIo.readObjectFromFile(fileName);
	}catch(FileNotFoundException e) {
		System.out.println("File not found");
	}catch(IOException e) {
		System.out.println("IO Error reading file");
	}catch(ClassNotFoundException e) {
		System.out.println("Class Not Found");
	}
	return players;
}


public void savePlayers(PlayerList players) {
	try
	{
	fileIo.writeToFile(fileName, players);
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