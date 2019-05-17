package trash;

import java.io.IOException;
import java.io.FileNotFoundException;

public class PlayersAdapter {
	private MyFileIo fileIo;
	private String fileName;
}

public PlayersAdapter(String fileName) {
	this.fileIo= new MyFileIo();
	this.fileName=fileName;
}

public PlayersList getAllPlayers() {
	PlayersList players = new PlayersList();
	
	try {
		players = (PlayersList) fileIo.readObjectFromFile(fileName);
	}catch(FileNotFoundException e) {
		System.out.println("File not found");
	}catch(IOException e) {
		System.out.println("IO Error reading file");
	}catch(ClassNotFoundException e) {
		System.out.println("Class Not Found");
	}
	return players;
}

public PlayerList getAllAvaliablePlayers() {
	PlayersList players = new PlayersList();
	
	try {
		players = (PlayersList) fileIo.readObjectFromFile(fileName);
	}catch(FileNotFoundException e) {
		System.out.println("File not found");
	}catch(IOException e) {
		System.out.println("IO Error reading file");
	}catch(ClassNotFoundException e) {
		System.out.println("Class Not Found");
	}
	
	return players.getAllAvailablePlayers();
}
}