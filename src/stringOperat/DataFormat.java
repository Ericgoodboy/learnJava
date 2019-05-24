package stringOperat;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import sun.util.calendar.BaseCalendar;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


/*
* 格式化日期
*
* */
public class DataFormat {
    public static void main(String [] srgs){
        Date date = new Date();
        DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println("中国时间："+formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
        System.out.println("日本时间："+formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("加拿大时间："+formater.format(date));
    }
}
