package com.fanshr.step.dao;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/8 17:21
 * @date : Modified at 2022/2/8 17:21
 */
public class SimpleTest {


    @Test
    public void test195(){

        System.out.println(strToWeek("2022-02-08"));


    }

    private String strToWeek(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String result = "";
        try {
            date = sdf.parse(str);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);
            calendar.setTime(date);

            switch (calendar.get(Calendar.DAY_OF_WEEK)){
                case 2:result = "星期一";break;
                case 3:result = "星期二";break;
                case 4:result = "星期三";break;
                case 5:result = "星期四";break;
                case 6:result = "星期五";break;
                case 7:result = "星期六";break;
                case 1:result = "星期日";
            }






        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
