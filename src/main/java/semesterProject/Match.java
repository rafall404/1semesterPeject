package semesterProject;

import java.util.ArrayList;

public class Match
{
   private String type;
   private static final String[] TYEPS = { "" };
   private MyDate date;
   private String place;
   private String opponent;
   private PlayerList team;

   public Match(String type, MyDate date, String place, String opponent)
   {
      this.type = type;
      this.date = date;
      this.place = place;
      this.opponent = opponent;
      team = new PlayerList();
   }

   public Match(String type, MyDate date, String place)
   {
      this.type = type;
      this.date = new MyDate();
      this.place = place;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String getType()
   {
      return type;
   }

   public void setDate(MyDate date)
   {
      this.date = date.copy();
   }

   public MyDate getDate()
   {
      return date.copy();
   }

   public void setPlace(String place)
   {
      this.place = place;
   }

   public String getPlace()
   {
      return place;
   }

   public void setOpponent(String opponent)
   {
      this.opponent = opponent;
   }

   public String getOpponent()
   {
      return opponent;
   }

   public String toString()
   {
      return "Type: " + type + ", date: " + date + ", place: " + place
            + ", opponent: " + opponent + ".";
   }

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

   public boolean isMatchPassed()
   {
      if (date.isBefore(date.today()))
      {
         return true;
      }
      return false;
   }

   public PlayerList getPlayerList()
   {
      return team;
   }

   public void setPlayerList(PlayerList team)
   {
      this.team = team;
   }
}


