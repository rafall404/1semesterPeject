package semesterProject;



public class ProgramMediator
{
  private MatchesList matchesList;
  private PlayerList playerList;
  private PlayersAdapter playerAdapter;
  private MatchesAdapter matchesAdapter;
  
  public ProgramMediator()
  { 
     this.playerAdapter = new PlayersAdapter("players.bin");
     this.matchesAdapter = new MatchesAdapter("matches.bin");
     this.matchesList = matchesAdapter.loadAllMatches();
     this.playerList = playerAdapter.loadAllPlayers();
  }
  public void addPlayer(String name,int number, char position)
  {
	 playerList.addPlayer(new Player(name,number,position));
	 
	 playerAdapter.savePlayers(playerList);
  }
  
  public void removePlayer(Player nigga)
  {
	  playerList.removePlayer(nigga);
  }
  
  
  
  public MatchesList getMatchList()
  {
	  return matchesList;
  }
  
  public void removeMatch(Match match)
  {
	matchesList.addMatch(match); 
  }
  
  public void addMatch(String type,MyDate date,String place,String opponent)
  {
	 matchesList.addMatch(new Match(type,date,place,opponent));
  }
  
}
