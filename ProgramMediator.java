

public class ProgramMediator
{
  private MatchesList matchesList;
  private PlayerList playerList;
  
  public ProgramMediator(MatchesList matchesList, PlayerList playerList)
  {
	  this.matchesList= matchesList;
	  this.playerList= playerList;
	  
  }
  
  public PlayerList getPlayerList()
  {
	  return playerList;
  }
  
  public void removePlayer(Player player)
  {
	  playerList.removePlayer(player);
  }
  
  public void addPlayer(String name,int number, char Position)
  {
	 playerList.addPlayer(new Player(name,number,Position));
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
