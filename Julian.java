
public class Julian  {

	 /*Unformatted Date: ddmmyyyy*/
	String unformattedDate;
    double resultJulian = 0;
    if(unformattedDate.length() > 0)
    {
     /*Days of month*/
     int[] monthValues = {31,28,31,30,31,30,31,31,30,31,30,31};

     String dayS, monthS, yearS;
     dayS = unformattedDate.substring(0,2);
     monthS = unformattedDate.substring(3, 5);
     yearS = unformattedDate.substring(6, 10);

     /*Convert to Integer*/
     int day = Integer.valueOf(dayS);
     int month = Integer.valueOf(monthS);
     int year = Integer.valueOf(yearS); 

         //Leap year check
         if(year % 4 == 0)
         {
          monthValues[1] = 29;    
         }
         //Start building Julian date
         String julianDate = "1";
         //last two digit of year: 2012 ==> 12
         julianDate += yearS.substring(2,4);

         int julianDays = 0;
         for (int i=0; i < month-1; i++)
         {
          julianDays += monthValues[i];
         }
         julianDays += day;

             if(String.valueOf(julianDays).length() < 2)
             {
              julianDate += "00";
             }
             if(String.valueOf(julianDays).length() < 3)
             {
              julianDate += "0";
             }

        julianDate += String.valueOf(julianDays);
    resultJulian =  Integer.valueOf(julianDate);    
 }
 return resultJulian;
}
}
