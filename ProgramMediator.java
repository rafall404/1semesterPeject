package semesterProject;



public class ProgramMediator
{
  private MatchesList matchesList;
  private PlayerList playerList;
  private PlayersAdapter playerAdapter;
  private MatchesAdapter matchesAdapter;
  
  public ProgramMediator()
  { 
     MatchesList matches = new MatchesList();
     PlayerList players = new PlayerList();
     this.playerAdapter = new PlayersAdapter("somethingoriginallikeadidas.png");
     this.matchesAdapter = new MatchesAdapter("somethingoriginallikeadidas.bin");
  }
  
  public void addPlayer()
  {
	 players
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
