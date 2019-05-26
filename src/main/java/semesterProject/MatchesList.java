package application;

import java.util.ArrayList;

/**
 * A class containing a Match object
 * @author Matey Matev
 * @version 1.0
 */
public class MatchesList
{
   private ArrayList<Match> matches;
   
   /**
    * No-argument constructor initializing the matchList
    */
   public MatchesList()
   {
      matches = new ArrayList<Match>();
   }
   
   /**
    * add a player to the list
    * @param player the player to add to the list
    */
   public void addMatch(Match match)
   {
      matches.add(match);
   }
   /**
    * @return the number of the Matches in the MatchList
    */
   public int getNumberOfMatches()
   {
      return matches.size();
   }
   
   /**
    * @return List of all player objects from playerList
    */
   public ArrayList<Match> getAllMatches()
   {
      return matches;
   }
   
   /**
    * @param temp the temp is an ArrayList object of type Match
    * @return if Matches at int i is passed, return player list
    */
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

   /**
    * @param temp the temp is an ArrayList object of type Match
    * @return if Matches at int i is upcoming, return player list
    */
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

   /**
    * Gets a match from the List by type
    * @param type the type in the list of the Match Object
    * @return the Match with type if one exists, else return null
    */
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

   /**
    * Gets a match from the List by place
    * @param place the place in the list of the Match Object
    * @return the Match with place if one exists, else return null
    */
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

   /**
    * Gets a match from the List by opponent
    * @param opponent the opponent in the list of the Match Object
    * @return the Match with opponent if one exists, else return null
    */
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

   /**
    * Gets a match from the List by type
    * @param type the type in the list of the Match Object
    * @return the Match with type if one exists, else return null
    */
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

   /**
    * remove a match from the list
    * @param match the match to remove from the list
    */
   public void removeMatch(Match match)
   {
      matches.remove(match);
   }

}
