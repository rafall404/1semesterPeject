package semesterProject;

import java.util.ArrayList;

public class MatchesList
{
   private ArrayList<Match> matches;

   public MatchesList()
   {
      matches = new ArrayList<Match>();
   }

   public void addMatch(Match match)
   {
      matches.add(match);
   }

   public int getNumberOfMatches()
   {
      return matches.size();
   }

   public ArrayList<Match> getAllMatches()
   {
      return matches;
   }

   public ArrayList<Match> getAllPastMatches()
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (matches.get(i).isMatchPassed())
            ;
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public ArrayList<Match> getAllUpcomingMatches()
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (!(matches.get(i).isMatchPassed()))
            ;
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public ArrayList<Match> getMatchesByType(String type)
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (matches.get(i).getType().equals(type))
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public ArrayList<Match> getMatchesByPlace(String place)
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (matches.get(i).getPlace().equals(place))
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public ArrayList<Match> getMatchesByOpponent(String opponent)
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (matches.get(i).getPlace().equals(opponent))
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public ArrayList<Match> getMatchByDate(MyDate date)
   {
      ArrayList<Match> temp = new ArrayList<Match>();

      for (int i = 0; i < matches.size(); i++)
      {
         if (matches.get(i).getDate().equals(date))
            ;
         {
            temp.add(matches.get(i));
         }
      }
      return temp;
   }

   public void removeMatch(Match match)
   {
      matches.remove(match);
   }

}
