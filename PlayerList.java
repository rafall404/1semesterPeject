package semesterProject;

import java.util.ArrayList;

public class PlayerList
{

   private ArrayList<Player> player;

   public PlayerList()
   {
      this.player = new ArrayList<Player>();

   }

   public void addPlayer(Player player)
   {
      this.player.add(player);
   }

   public int getNumberOfPlayers()
   {
      return player.size();
   }

   public ArrayList<Player> getAllPlayers()
   {
      return player;
   }

   public ArrayList<Player> getAllAvailablePlayers()
   {
      ArrayList<Player> temp = new ArrayList<Player>();

      for (int i = 0; i < player.size(); i++)
      {
         if (!player.get(i).isInjured() && !player.get(i).isSuspended())
            temp.add(player.get(i));
      }
      return temp;
   }

   public Player getPlayer(int index)
   {
      return player.get(index);
   }

   public Player getPlayerByName(String name)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getName().equals(name))
            return player.get(i);
      }
      
      return null;
   }

   public ArrayList<Player> getPlayersByPosition(char position)
   {
      ArrayList<Player> temp = new ArrayList<Player>();
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getPosition() == position)
            temp.add(player.get(i));
      }
      return temp;
   }

   public Player getPlayerbyNumber(int number)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getNumber() == (number))
            return player.get(i);

      }
      return null;
   }

   public void removePlayer(Player player)
   {
      this.player.remove(player);
   }

   public String toString()
   {
      return "The players are:" + "/n" + player;
   }

}
