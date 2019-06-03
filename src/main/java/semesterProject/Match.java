package semesterProject;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A class of  Match object
 * @author Aleksandrs Fjodorovs
 * @version 1.0
 */
public class Match implements Serializable
{
   private String type;
   private LocalDateTime localDateTime;
   private String place;
   private String opponent;
   private PlayerList team;

   /**
    *
    * @param localDateTime
    * @param opponent
    * @param place
    * @param type
    */
   public Match(LocalDateTime localDateTime, String opponent, String place, String type)
   {
      this.localDateTime = localDateTime;
      this.type = type;
      this.place = place;
      this.opponent = opponent;
      team = new PlayerList();
   }

   /**
    *
    * @param localDateTime
    * @param opponent
    * @param place
    * @param type
    * @param team
    */

   public Match( LocalDateTime localDateTime,String opponent, String place,String type,PlayerList team) {
      this.localDateTime = localDateTime;
      this.opponent = opponent;
      this.place = place;
      this.type = type;
      this.team = team;
   }
   public LocalDate getDate() {
      return localDateTime.toLocalDate();
   }

   /**
    *
    * @param localDateTime
    */
   public void setLocalDateTime(LocalDateTime localDateTime)
   {
      this.localDateTime = localDateTime;
   }
   /*

    */
   public LocalDateTime getLocalDateTime() {
      return localDateTime;
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
      return "Type: " + type + ", date and time " + localDateTime+", place: "+ place +" + opponent + "+opponent+"team:" + team.toString();
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

      return type.equals(other.type) && localDateTime.equals(other.localDateTime)
            && place.equals(other.place) && opponent.equals(other.opponent);
   }
   /**
    * @return true if date of match is before static method today 
    */
   public boolean isMatchPassed()
   {
      if (localDateTime.isBefore(LocalDateTime.now()))
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


