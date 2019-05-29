package semesterProject;

import java.io.Serializable;

/**
 * A class of  Player object
 * @author Rafal Pierscienak
 * @version 1.0
 */
public class Player implements Serializable
{
   private String name;
   private int number;
   private char position;
   private boolean isInjured;
   private boolean isSuspended;

   /**
    * @param name the name of the Player will be set
    * @param number the number of the Player will be set
    * @param position the position of the PLayer will be set
    * @param IsInjured the IsInjured of the Player will be set
    * @param IsSuspended the IsSuspended of the Player will be set
    */
   public Player(String name, int number, char position, boolean isInjured,
         boolean isSuspended)
   {
      this.name = name;
      this.number = number;
      this.position = position;
      this.isInjured = isInjured;
      this.isSuspended = isSuspended;
   }

   /**
    * @param name the name of the Player will be set
    * @param number the number of the Player will be set
    * @param position the position will be set
    */
   public Player(int number, String name, char position)
   {
      this.name = name;
      this.number = number;
      this.position = position;
      this.isInjured = false;
      this.isSuspended = false;
   }

   /**
    * replaces the name object with name
    * @param name the name will be replaced
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Gets a String name from the class
    * @return the name of the Player
    */
   public String getName()
   {
      return name;
   }

   /**
    * replaces the number object with number
    * @param number of number will be replaced
    */
   public void setNumber(int number)
   {
      this.number = number;
   }

   /**
    * Gets a number object from the class
    * @return the number of the Player
    */
   public int getNumber()
   {
      return number;
   }

   /**
    * replaces the position object withposition
    * @param position the position will be replaced
    */
   public void setPosition(char position)
   {
      this.position = position;
   }

   /**
    * Gets the Position object from the class
    * @return the position of the Player
    */
   public char getPosition()
   {
      return position;
   }

   /**
    * replaces the IsInjured object with IsInjured
    * @param Isinjured the IsInjured will be replaced
    */
   public void setIsInjured(boolean isInjured)
   {
      this.isInjured = isInjured;
   }

   /**
    * Gets the IsInjured object from the class
    * @return the IsInjured of the Player
    */ 
   public boolean isInjured()
   {
      return isInjured;
   }

   /**
    * replaces the IsSuspended object with IsSuspended
    * @param IsSuspended the IsSuspended will be replaced
    */
   public void setIsSuspended(boolean isSuspended)
   {
      this.isSuspended = isSuspended;
   }

   /**
    * Gets the IsSuspended object from the class
    * @return the IsSuspended of the Player
    */
   public boolean isSuspended()
   {
      return isSuspended;
   }

   /**
    * no param method returning String object
    */
   public String toString()
   {
      return name + ", " + number + ", " + position + ", " + isInjured + ", "
            + isSuspended;
   }

   /**
    * @ param obj return false if not instance of Match class
    * @ param obj is equals to other object instance of Match
    * @ return true if this class variables is equal to other class variables
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Player))
      {
         return false;
      }

      Player other = (Player) obj;

      return (other.name.equals(name) && other.number == number
            && other.position == position && other.isInjured == isInjured
            && other.isSuspended == isSuspended);
   }

}
