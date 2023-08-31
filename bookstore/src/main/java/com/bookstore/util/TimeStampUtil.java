package com.bookstore.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;

public class TimeStampUtil {
	
	
		
	

    // 2021.03.24.16.34.26
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    // 2021-03-24T16:44:39.083+08:00
    //private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    
    // 2021-03-24T16:44:39.083
    //2023-08-30T14:45:59.816Z
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    // 2021-03-24 16:48:05
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  // public static void main(String[] args) {

        // method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //System.out.println(timestamp);                      // 2021-03-24 16:34:26.666

        // method 2 - via Date
        Date date = new Date();
       // System.out.println(new Timestamp(date.getTime()));  // 2021-03-24 16:34:26.666
                                                            // number of milliseconds since January 1, 1970, 00:00:00 GMT
       // System.out.println(timestamp.getTime());            // 1616574866666

      //  System.out.println(sdf1.format(timestamp));         // 2021.03.24.16.34.26

      //  System.out.println(getDateFormat());         // 2021-03-24T16:48:05.591z

       // System.out.println(sdf3.format(timestamp));         // 2021-03-24 16:48:05

	//}
   
   public static String getDateFormat() {
	   
	   return sdf2.format(getTimeStamp());
   }
    
    public static long getTimeStamp() {
    	
    	/* Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	return timestamp.getTime();*/
    	
    	return Clock.systemUTC().millis();
    	
    	
    }
}