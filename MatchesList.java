package VIAClubManagementSystem;

import java.util.ArrayList;

public class MatchesList
{
   private ArrayList<Matches> matches;

   public MatchesList()
   {
      matches = new ArrayList<Matches>();
   }

   public void addMatch(Match match)
   {
      matches.add(match);
   }

   public int getNumberOfMatches()
   {
      return matches.size();
   }
   public Match[] getAllMatches()
   {
      
   }
   public Match[] getAllUpcomingMatches()
   {
      
   }
   public MatchesList getMatchesByType(String type)
   {
      
   }

}
