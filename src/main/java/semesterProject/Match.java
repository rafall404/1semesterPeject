package semesterProject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class of  Match object
 * @author Aleksandrs Fjodorovs
 * @version 1.0
 */
public class Match implements Serializable
{
   private String type;
   private static final String[] TYEPS = { "" };
   private MyDate date;
   private String place;
   private String opponent;
   private PlayerList team;
   /**
    * @param type the type of the match will be set
    * @param date the date of the match will be set
    * @param place the place of the match will be set
    * @param opponent the opponent of the match will be set
    */
   public Match(MyDate date, String opponent, String place, String type)
   {
      this.type = type;
      this.date = date;
      this.place = place;
      this.opponent = opponent;
      team = new PlayerList();
   }
   
   /**
    * @param date the date of the match will be set
    * @param  opponent the opponent of the match will be set
    * @param place the place of the match will be set
    * @param  type the type of the match will be set
    */
   public Match( MyDate date,String opponent, String place,String type,PlayerList team)
   {
      this.date= date;
      this.opponent=opponent;
      this.place = place;
      this.type= type;
      this.team=team;
   }
   
   /**
    * replaces the type object with type
    * @param type the type of the match will be replaced
    */
   public void setType(String type)
   {
      this.type = type;
   }
   /**
    * Gets a String type from the class
    * @return the type of Match
    */
   public String getType()
   {
      return type;
   }
   
   /**
    * replaces the date object with date
    * @param date the date of the match will be replaced
    */
   public void setDate(MyDate date)
   {
      this.date = date.copy();
   }
   
   /**
    * Gets a date object from the class
    * @return the date of Match
    */
   public MyDate getDate()
   {
      return date.copy();
   }
   
   /**
    * replaces the place object with place
    * @param place the place of the match will be replaced
    */
   public void setPlace(String place)
   {
      this.place = place;
   }
   
   /**
    * Gets a place object from the class
    * @return the place of Match
    */
   public String getPlace()
   {
      return place;
   }
   
   /**
    * replaces the opponent object with opponent
    * @param opponent the opponent of the match will be replaced
    */
   public void setOpponent(String opponent)
   {
      this.opponent = opponent;
   }
   
   /**
    * Gets a place object from the class
    * @return the place of Match
    */
   public String getOpponent()
   {
      return opponent;
   }
   
   /**
    * no param method returning String object
    */
   public String toString()
   {
      return "Type: " + type + ", date: " + date + ", place: " + place
            + ", opponent: " + opponent + "." + team.toString();
   }
   
   /**
    * @ param obj return false if not instance of Match class
    * @ param obj is equals to other object instance of Match
    * @ return true if this class variables is equal to other class variables
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Match))
      {
         return false;
      }

      Match other = (Match) obj;

      return type.equals(other.type) && date == other.date
            && place.equals(other.place) && opponent.equals(other.opponent);
   }
   /**
    * @return true if date of match is before static method today 
    */
   public boolean isMatchPassed()
   {
      if (date.isBefore(date.today()))
      {
         return true;
      }
      return false;
   }
   
   /**
    * Gets a playerList object from the class
    * @return the team of Match
    */
   public PlayerList getPlayerList()
   {
      return team;
   }
   
   /**
    * replaces the playerList object with playerList
    * @param team the team of the match will be replaced
    */
   public void setPlayerList(PlayerList team)
   {
      this.team = team;
   }
}


