package semesterProject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of player objects
 * @ author Simon Emmanuel
 * @ version 1.0
 */
public class PlayerList implements Serializable
{

   private ArrayList<Player> player;
   
   /**
    * No argument constructor initializing the PlayerList
    */
   public PlayerList()
   {
      this.player = new ArrayList<Player>();

   }
   /**
    * Adds a player to the list
    * @param player the player to add to the list
    */
   public void addPlayer(Player player)
   {
      this.player.add(player);
   }
   
   /**
    * @return the number of the players in the playerList
    */
   public int getNumberOfPlayers()
   {
      return player.size();
   }
   
   /**
    * @return List of all player objects from playerList
    */
   public ArrayList<Player> getAllPlayers()

   {

      return player;

   }
   
   /**
    * @param temp the temp is an ArrayList object
    * @return if player at i is not injured or suspended, return player list
    */
   public PlayerList getAllAvailablePlayers()
   {
      PlayerList temp = new PlayerList();

      for (int i = 0; i < player.size(); i++)
      {
         if (!player.get(i).isInjured() && !player.get(i).isSuspended())
            temp.addPlayer(player.get(i));
      }
      return temp;
   }
   
   /**
    * Gets a player from position index from the List
    * @param index the position in the list of the Player Object
    * @return the player at index if one exists, else return null
    */
   public Player getPlayer(int index)
   {
      return player.get(index);
   }
   
   /**
    * Gets a player from position index from the List by name
    * @param name the name in the list of the Player Object
    * @return the player with name if one exists, else return null
    */
   public Player getPlayerByName(String name)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getName().equals(name))
            return player.get(i);
      }
      
      return null;
   }
   
   /**
    * Gets  player objects by char position from the List
    * @param position the position in the list of the Player Object
    * @return the players at position if one exists, else return null
    */
   public PlayerList getPlayersByPosition(char position)
   {
	   
      PlayerList temp = new PlayerList();
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getPosition() == position)
            temp.addPlayer(player.get(i));
      }
      return temp;
   }
   
   /**
    * Gets a player with int number from the List
    * @param number the number in the list of the Player Object
    * @return the player with number if one exists, else return null
    */
   public Player getPlayerbyNumber(int number)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getNumber() == (number))
            return player.get(i);

      }
      return null;
   }
   
   /**
    * remove a player from the list
    * @param player the player to remove from the list
    */
   public void removePlayer(Player player)
   {
      this.player.remove(player);
   }

   /**
    * no param method returning String object
    */
   public String toString()
   {
      return "The players are:" + "/n" + player;
   }

   public ArrayList<Player> convertToAList() {return player;}
}
