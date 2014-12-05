/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: DateUtil.java
 * Author:   12090707
 * Date:     2014-3-21 下午4:16:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * 日期工具类<br>
 * 
 */
public class DateUtil {
    public static String POS_DATE_FORMATE = "yyyyMMdd";

    /**
     * 日期格式 yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    
    /**
     * 日期格式 yyyy-MM-dd hh:mm
     */
    public static final String DEFAULT_DATE_PATTERN_FORMAT = "yyyy-MM-dd hh:mm";

    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DEFAULY_FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 功能描述: 判断当前时间是否在给定时间区间内<br>
     * 
     * @param beginTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @return 当前时间大于等于开始时间且小于结束时间返回True，否则false
     */
    public static boolean isNowTimeBetween(Date beginTime, Date endTime) {

        return isTimeBetween(new Date(), beginTime, endTime);
    }

    /**
     * 功能描述: 比较时间是否在某个时间段内<br>
     * 
     * @param checkTime
     *            待比较时间
     * @param beginTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @return 如果待比较时间大于等于开始时间且小于结束时间返回true，否则false
     */
    public static boolean isTimeBetween(Date checkTime, Date beginTime, Date endTime) {

        return (checkTime.after(beginTime) || checkTime.equals(beginTime)) && checkTime.before(endTime);
    }

    /**
     * 
     * 功能描述: 返回当前时间 时间格式 yyyy-MM-dd HH:mm:ss.SSS<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getNowFullStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULY_FULL_TIME_PATTERN);
        return sdf.format(new Date());
    }

    /**
     * 
     * 功能描述: 获取当前日期 yyyy-MM-dd<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getNowShortStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        return sdf.format(new Date());
    }
    
    /**
     * 
     * 功能描述: 获取当前日期 yyyy-MM-dd hh:mm<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getNowShortmmStr(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_PATTERN_FORMAT);
        return sdf.format(time);
    }

    /**
     * 获取系统日期所在周的日期范围；或者所在月份的日期范围
     * 
     * @param type
     *            week/month
     * @return
     */
    public static HashMap<String, Calendar> getRangeBySysDate(String type) {
        HashMap<String, Calendar> ret = new HashMap<String, Calendar>();
        ;
        Calendar current = Calendar.getInstance();
        Calendar begin = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        if (type == "week") {
            switch (current.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                    end.add(Calendar.DATE, 6);
                    break;

                case Calendar.MONDAY:
                    begin.add(Calendar.DATE, -1);
                    end.add(Calendar.DATE, 5);
                    break;

                case Calendar.TUESDAY:
                    begin.add(Calendar.DATE, -2);
                    end.add(Calendar.DATE, 4);
                    break;

                case Calendar.WEDNESDAY:
                    begin.add(Calendar.DATE, -3);
                    end.add(Calendar.DATE, 3);
                    break;

                case Calendar.THURSDAY:
                    begin.add(Calendar.DATE, -4);
                    end.add(Calendar.DATE, 2);

                case Calendar.FRIDAY:
                    begin.add(Calendar.DATE, -5);
                    end.add(Calendar.DATE, 1);
                    break;

                case Calendar.SATURDAY:
                    begin.add(Calendar.DATE, -6);
                    break;
            }

        } else if (type == "month") {

            begin.set(Calendar.DATE, 1);
            end.set(Calendar.DATE, current.getActualMaximum(Calendar.DAY_OF_MONTH));

        } else {
            return null;
        }

        ret.put("begin", begin);
        ret.put("end", end);

        return ret;
    }

    /**
     * 解析时间字符串<br>
     * 
     * @param source
     * @param pattern
     * @return
     */
    public static Date parse(String source, String pattern) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当日0时时间
     * 
     * @return
     */
    public static Date getCurrentStartDate(Date input) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(input);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();

    }

    /**
     * 获取当日0时时间
     * 
     * @return
     */
    public static Date getNextDayStartDate(Date input) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(input);
        todayStart.add(Calendar.DATE, 1);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();

    }

    /**
     * 获取当日结束时间
     * 
     * @return
     */
    public static Date getCurrentEndDate(Date input) {

        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(input);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();

    }

    /**
     * 获取下一日结束时间
     * 
     * @return
     */
    public static Date getNextEndDate(Date input) {

        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(input);
        todayEnd.add(Calendar.DATE, 1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();

    }

    /**
     * 
     * 功能描述： 输入参数：计算传入时间的前几天或者后几天的时间
     * 
     * @param time
     *            传入的日期
     * @param days
     *            天数，可正负
     * @return calendar 计算后的日期
     */
    public static Calendar addDays(Date time, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, days);
        return calendar;
    }

    /**
     * 功能描述: <br>
     * 计算两个时间的间隔天数
     * 
     * @return
     * @throws ParseException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static int daysGap(Date begDate, Date endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date locBegDate = sdf.parse(sdf.format(begDate));
        Date locEndDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(locBegDate);
        long begTime = cal.getTimeInMillis();
        cal.setTime(locEndDate);
        long endTime = cal.getTimeInMillis();
        long between_days = (endTime - begTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 功能描述: 获得次天的零点时间<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date getNextDayZeroPoint() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 功能描述: 获得当天的零点时间<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date getTodayZeroPoint() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 功能描述: 获得当年最后一天时间<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date getThisYearLastTime() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DAY_OF_MONTH, 31);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
}
