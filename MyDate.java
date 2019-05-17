package semesterProject;

import java.util.GregorianCalendar;

public class MyDate
{
   private int day;
   private int month;
   private int year;

   public MyDate(int d, int m, int y)
   {
      this.day = d;
      this.month = m;
      this.year = y;
   }
   

   public MyDate()
   {
      this.day = 0;
      this.month = 0;
      this.year = 0;
   }

   public String toString()
   {
      return " "+day + "/" + month + "/" + year;
   }

   public int getYear()
   {
      return this.year;
   }

   public int getMonth()
   {
      return this.month;
   }

   public int getDay()
   {
      return this.day;
   }

   public void setDay(int d)
   {
      day = d;
   }

   public void setMonth(int m)
   {
      month = m;
   }

   public void setYear(int y)
   {
      year = y;
   }

   public boolean isLeapYear()
   {
      if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
         return true;
      else
         return false;
   }

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

   public String getAstroSign()
   {
      if (month == 3 && day >= 21 || month == 4 && day <= 19)
         return "Aries";
      else if (month == 4 && day >= 20 || month == 5 && day <= 20)
         return "Taurus";
      else if (month == 5 && day >= 21 || month == 6 && day <= 20)
         return "Gemini";
      else if (month == 6 && day >= 21 || month == 7 && day <= 22)
         return "Cancer";
      else if (month == 7 && day >= 23 || month == 8 && day <= 22)
         return "Leo";
      else if (month == 8 && day >= 23 || month == 9 && day <= 22)
         return "Virgo";
      else if (month == 9 && day >= 23 || month == 10 && day <= 22)
         return "Libra";
      else if (month == 10 && day >= 23 || month == 11 && day <= 21)
         return "Scorpio";
      else if (month == 11 && day >= 22 || month == 12 && day <= 21)
         return "Sagittarius";
      else if (month == 12 && day >= 22 || month == 1 && day <= 19)
         return "Capricorn";
      else if (month == 1 && day >= 20 || month == 2 && day <= 18)
         return "Aquarius";
      else if (month == 2 && day >= 19 || month == 3 && day <= 20)
         return "Pisces";
      else
         return "Whore";
   }

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

   public String getMonthName()
   {
      switch (month)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            return null;
      }
   }

   public void nextDay()
   {
      this.day++;

      if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7
            || month == 8 || month == 10)) // 1,3,5,7,8,10
      {
         day = 1;
         month++;
      }
      else if (day > 30
            && (month == 4 || month == 6 || month == 9 || month == 11)) // 4,6,9,11
      {
         day = 1;
         month++;
      }
      else if ((day > 28 && month == 2 && !isLeapYear())
            || (day > 29 && month == 2 && isLeapYear()))
      {
         day = 1;
         month++;
      }
      else if (day > 31 && month == 12)
      {
         day = 1;
         month = 1;
         year++;
      }

   }

   public String displayDate()
   {
      return day + "/" + month + "/" + year;
   }

   public boolean equals(Object obj)
   {
     if (!(obj instanceof MyDate)) {
        return false;
     }
     MyDate other = (MyDate)obj;
     return day == other.day &&
           month == other.month &&
           year == other.year;
   }

   public MyDate copy()
   {
      return new MyDate(day, month, year);
   }

   public MyDate(MyDate object)
   {
      day = object.day;
      month = object.month;
      year = object.year;
   }

   public void nextDays(int days)
   {
      for (int i = 0; i < days; i++)
      {
         nextDay();
      }
   }

   public boolean isBefore(MyDate date2)
   {
      if (year < date2.year)
      {
         return true;
      }
      else if (year== date2.year && month < date2.month)
      {
         return true;
      }
      else if(year == date2.year && month == date2.month && day < date2.day)
      {
         return true;
      }
        else
        {
            return false;
      }
   }

   public static MyDate today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      MyDate d = new MyDate(currentDay, currentMonth, currentYear);
      return d;
   }
   
}
