package semesterProject;

import java.util.GregorianCalendar;

/**
 * A class of  Match object
 * @author Aleksandrs Fjodorovs,
 * @version 1.0
 */
public class MyDate
{
   private int day;
   private int month;
   private int year;
   
   /**
    * @param day the day of myDate will be set
    * @param month the month of myDate will be set
    * @param year the year of myDate will be set
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
      return " " + day + "/" + month + "/" + year;
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
   public boolean isLeapYear()
   {
      if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
         return true;
      else
         return false;
   }
 /**
  * @return 31 if month has 31 days 
  * @return 30 if month has 30 days
  * @return 29 if month is 2 and is leap year
  * @return 28 if month is 2 and not a leap year 
  * @return -1 if month is unknown
  */
   public int daysInMonth()
   {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12)
      {
         return 31;
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
         return 30;
      }
      else if (month == 2)
      {
         if (isLeapYear())
            return 29;
         else
            return 28;
      }
      else
      {
         return -1;
      }

   }

   /**
    * Gets the name of the day of the week 
    * @return Saturday if h == 0
    * @return Sunday if h == 1
    * @return Monday if h == 2
    * return Tuesday if h == 3
    * @return Wednesday if h == 4
    * @return Thursday if h == 5
    * @return Friday if h == 6, else return error
    */
   public String dayOfWeek()
   {
      int q = day;
      int m = month;
      int y = year;

      if (m == 1)
      {
         m = 13;
         y = year - 1;
      }
      else if (m == 2)
      {
         m = 14;
         y = year - 1;
      }

      int k = year % 100;
      int j = year / 100;
      int h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

      if (h == 0)
         return "Saturday";
      else if (h == 1)
         return "Sunday";
      else if (h == 2)
         return "Monday";
      else if (h == 3)
         return "Tuesday";
      else if (h == 4)
         return "Wednesday";
      else if (h == 5)
         return "Thursday";
      else if (h == 6)
         return "Friday";
      else
         return "error";

   }

   

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
