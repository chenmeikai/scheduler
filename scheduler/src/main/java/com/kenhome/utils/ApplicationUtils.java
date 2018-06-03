package com.kenhome.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * The type Application utils.
 */
public class ApplicationUtils {

    /**
     * Format date string.
     *
     * @param date the date
     * @return the string
     */
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * Get current datetime
     *
     * @return string
     */
    public static String currentDateTime() {
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return simpleDateFormat.format(new Date());
    }
}
