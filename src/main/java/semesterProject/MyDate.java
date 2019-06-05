package semesterProject;
import java.io.Serializable;

import java.util.GregorianCalendar;

/**
 * A class of  Match object
 * @author Aleksandrs Fjodorovs,
 * @version 1.0
 */
public class MyDate implements Serializable
{
   private int day;
   private int month;
   private int year;
   
   /**
    * @param d the day of myDate will be set
    * @param m the month of myDate will be set
    * @param y the year of myDate will be set
    */
   public MyDate(int d, int m, int y)
   {
      this.day = d;
      this.month = m;
      this.year = y;
   }

   /**
    * No argument constructor initializing the PlayerList
    */
   public MyDate()
   {
      this.day = 0;
      this.month = 0;
      this.year = 0;
   }

   /**
    * no param method returning String object
    */
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }

   /**
    * Gets a year object from the class
    * @return the year of the myDate
    */
   public int getYear()
   {
      return this.year;
   }

   /**
    * Gets a month object from the class
    * @return the month of the myDate
    */
   public int getMonth()
   {
      return this.month;
   }

   /**
    * Gets a day object from the class
    * @return the day of the myDate
    */
   public int getDay()
   {
      return this.day;
   }

   /**
    * replaces the day object with d
    * @param d the day of the myDate will be replaced
    */
   public void setDay(int d)
   {
      day = d;
   }

   /**
    * replaces the month object with month
    * @param m the month of the myDate will be replaced
    */
   public void setMonth(int m)
   {
      month = m;
   }

   /**
    * replaces the year object with d
    * @param y the year of the myDate will be replaced
    */
   public void setYear(int y)
   {
      year = y;
   }

   /**
    * @return true if year of myDate is  a leap year 
    */


  /**
   * @param date2 the date Object of Mydate to compare with
   *  @return true if date of match is before date given as param, else return false
   */
   public boolean isBefore(MyDate date2)
   {
      if (year < date2.year)
      {
         return true;
      }
      else if (year == date2.year && month < date2.month)
      {
         return true;
      }
      else if (year == date2.year && month == date2.month && day < date2.day)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    *@return d of new object myDate with static gregorian calendar objects
    */
   public static MyDate today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      MyDate d = new MyDate(currentDay, currentMonth, currentYear);
      return d;
   }
   /**
    * @ param obj return false if not instance of myDate class
    * @ param obj is equals to other object instance of MyDate
    * @ return true if this class variables is equal to other class variables
    */
   public boolean equals(Object obj)
   {
	 if(!(obj instanceof Object))
		 return false;
	 
	 MyDate other = (MyDate) obj;
	 
	 return (day==other.day && month==other.month && year==other.year);
   }

   /**
    * Gets new obect Mydate equal to the field of the class 
    * @return a new myDate Object
    */
   public MyDate copy()
   {
	   return new MyDate(this.day,this.month,this.year);
   }
}
