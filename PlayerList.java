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
      return this.player.size();
   }

   public Player[] getAllPlayers()
   {
      return (Player[]) this.player.toArray();
   }

   public Player[] getAllAvailablePlayers()
   {
      ArrayList<Player> p = new ArrayList<Player>();
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getIsInjured() == true
               || player.get(i).getIsSuspended() == true)
            p.add(player.get(i));
      }
      return (Player[]) p.toArray();
   }

   public Player getPlayer(int Index)
   {
      return player.get(Index);
   }

   public Player getPlayerbyName(String name)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getName().equals(name))
            return player.get(i);

      }
      return null;
   }

   public Player getPlayersbyPosition(char Position)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getPosition().equals(Position))
            return player.get(i);

      }
      return null;
   }

   public Player getPlayerbyNumber(int number)
   {
      for (int i = 0; i < player.size(); i++)
      {
         if (player.get(i).getNumber().equals(number))
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
