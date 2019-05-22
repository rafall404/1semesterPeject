package semesterProject;


/**
 * A class containing a list of player objects
 * @ author Simon Emmanuel
 * @ version 1.0
 */
public class ProgramMediator
{
  private MatchesList matchesList;
  private PlayerList playerList;
  private PlayersAdapter playerAdapter;
  private MatchesAdapter matchesAdapter;
  
  /**
   * No argument constructor initializing the instance variables
   */
  public ProgramMediator()
  { 
     this.playerAdapter = new PlayersAdapter("players.bin");
     this.matchesAdapter = new MatchesAdapter("matches.bin");
     this.matchesList = matchesAdapter.loadAllMatches();
     this.playerList = playerAdapter.loadAllPlayers();
  }
  
  /**
   * Adds a player to the Player list 
   * @param name the name to add to the new player object
   * @param number the number to add to the new player object
   * @param position the position to add to the new player object
   */
  public void addPlayer(String name,int number, char position)
  {
	 playerList.addPlayer(new Player(name,number,position));
	 
	 playerAdapter.savePlayers(playerList);
  }
  
  /**
   * remove a player from the list
   * @param player the player to remove from the list
   */
  public void removePlayer(Player player)
  {
	  playerList.removePlayer(player);
  }
  
/**
 * @return all player objects in player list
 */
  public ArrayList<Player> getAllPlayers()
  {
     return playerList;
  }
  
  
  /**
   * Gets a player with String name from the List
   * @param name the name in the list of the Player Object
   * @return the player with name if one exists, else return null
   */
  public Player getPlayerByName(String name)
  {
     for (int i = 0; i < playerList.size(); i++)
     {
        if (player.get(i).getName().equals(name))
           return playerList.get(i);
     }
     
     return null;
  }
  
  /**
   * Gets  player objects by char position from the List
   * @param position the position in the list of the Player Object
   * @return the players at position if one exists, else return null
   */
  public ArrayList<Player> getPlayersByPosition(char position)
  {
     PlayerList temp = new PlayerList();
     for (int i = 0; i < playerList.size(); i++)
     {
        if (playerList.get(i).getPosition() == position)
           temp.add(playerList.get(i));
     }
     return temp;
  
  
}
