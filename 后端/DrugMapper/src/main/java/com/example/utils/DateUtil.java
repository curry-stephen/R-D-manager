package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return sdf.format(date);
    }
    public static Date StringToDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date parse =null;
        try {
            parse=format.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return parse;
    }
}
