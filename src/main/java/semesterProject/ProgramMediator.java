package semesterProject;

import java.util.ArrayList;

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

		System.out.println(matchesList);
	}

	/**
	 * Adds a player to the Player list 
	 * @param name the name to add to the new player object
	 * @param number the number to add to the new player object
	 * @param position the position to add to the new player object
	 */
	public void addPlayer(int number, String name,char position)
	{
		playerList.addPlayer(new Player(number,name,position));

		playerAdapter.savePlayers(playerList);
	}

	/**
	 * remove a player from the list
	 * @param player the player to remove from the list
	 */
	public void removePlayer(Player player)
	{
		playerList.removePlayer(player);
		
		playerAdapter.savePlayers(playerList);
	}

	/**
	 * @return all player objects in player list
	 */
	public PlayerList getAllPlayers()
	{
		return playerList;
	}

	public MatchesList getAllMatches()
	{
		return matchesList;
	}


	/**
	 * Gets a player with String name from the List
	 * @param name the name in the list of the Player Object
	 * @return the player with name if one exists, else return null
	 */
	public Player getPlayerByName(String name)
	{
		return playerList.getPlayerByName(name);
	}

	/**
	 * Gets  player objects by char position from the List
	 * @param position the position in the list of the Player Object
	 * @return the players at position if one exists, else return null
	 */
	public PlayerList getPlayersByPosition(char position) {
	return 	playerList.getPlayersByPosition(position);
	}

	/**
	 * Adds a player object to the list and refreshes the list
	 * @param player Object that should be added.
	 */
	public void addPlayer(Player player) {		
		playerList.addPlayer(player);

		playerAdapter.savePlayers(playerList);
	}

	public void editPlayer(Player player){
		playerAdapter.savePlayers(playerList);
	}

	/**
	 *  gets the information about object at position @param
	 * @param index is the parameter that the use enter to pick object at position
	 * @return object of Player
	 */
	public Player getPlayer(int index) {
	 return	playerList.getPlayer(index);
	}

	/**
	 *  counts the objects in the list
	 * @return the number of object stored
	 */
	public int getNumberOfPlayers() {
		return playerList.getNumberOfPlayers();
	}

	/**
	 *
	 * @param number
	 * @return
	 */
	public Player getPlayerByNumber(int number) {
		return playerList.getPlayerbyNumber(number);
	}

	/**
	 *  Creates Match object and it being added to the list
	 * @param match
	 */
	public void addMatch(Match match) {
		matchesList.addMatch(match);

		System.out.println("MATCHES LIST ADD: " + matchesList);

		matchesAdapter.saveMatches(matchesList);
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfMatches() {
		return matchesList.getNumberOfMatches();
	}

	/**
	 *
	 * @return
	 */
	public MatchesList getAllUpcomingMatches() {
		return matchesList.getAllUpcomingMatches();
	}

	/**
	 *
	 * @return
	 */
	public MatchesList getAllPastMatches() {
		return matchesList.getAllPastMatches();
	}

	/**
	 *
	 * @param type
	 * @return
	 */
	public MatchesList getMatchByType(String type) {
		return matchesList.getMatchesByType(type);
	}

	/**
	 *
	 * @param place
	 * @return
	 */
	public MatchesList getMatchByPlace(String place) {
		return matchesList.getMatchesByPlace(place);
	}

	/**
	 *
	 * @param opponent
	 * @return
	 */
	public MatchesList getMatchByOpponent(String opponent) {
		return matchesList.getMatchesByOpponent(opponent);
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public MatchesList getMatchByDate(MyDate date) {
		return matchesList.getMatchByDate(date);
	}

	/**
	 *
	 * @param match
	 */
	public void removeMatch(Match match)
	{
		matchesList.removeMatch(match);
		matchesAdapter.saveMatches(matchesList);
	}

}
