package com.mingnong.xizangphone.utils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wyw on 2016/11/7.
 * 一些单独针对本项目使用的util
 */

public class OtherUtil {

    public static String GET_JIANYI = null;

    public static String getGetJianyi() {
        return GET_JIANYI;
    }

    public static void setGetJianyi(String getJianyi) {
        GET_JIANYI = getJianyi;
    }
    public static String GET_CHANA = null;
    public static String GET_DONGB = null;
    public static String GET_DONGA = null;

    public static String getGetChana() {
        return GET_CHANA;
    }

    public static void setGetChana(String getChana) {
        GET_CHANA = getChana;
    }

    public static String getGetDongb() {
        return GET_DONGB;
    }

    public static void setGetDongb(String getDongb) {
        GET_DONGB = getDongb;
    }

    public static String getGetDonga() {
        return GET_DONGA;
    }

    public static void setGetDonga(String getDonga) {
        GET_DONGA = getDonga;
    }

    /**
     * 获取文本
     *
     * @param view textview | edittext
     * @return
     */
    public static String toString(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString();
        }
        if (view instanceof TextView) {
            return ((TextView) view).getText().toString();
        }
        return view.toString();
    }

    /**
     * startTime 大于等于 endTime 返回 true 说明有问题
     *
     * @param startTime yyyy-MM-dd 小时间
     * @param endTime   大时间
     * @return
     */
    public static boolean compareTime(String startTime, String endTime) {
        //分割 startTime
        String[] splitStart = startTime.split("-");
        String[] splitEnd = endTime.split("-");
        //2015 < 2016
        if (Integer.valueOf(splitStart[0]) < Integer.valueOf(splitEnd[0]) ||
                Integer.valueOf(splitStart[1]) < Integer.valueOf(splitEnd[1]) ||
                Integer.valueOf(splitStart[2]) < Integer.valueOf(splitEnd[2])) {
            return false;
        }
        if (Integer.valueOf(splitStart[0]).intValue() == Integer.valueOf(splitEnd[0]).intValue() &&
                Integer.valueOf(splitStart[1]).intValue() == Integer.valueOf(splitEnd[1]).intValue() &&
                Integer.valueOf(splitStart[2]).intValue() == Integer.valueOf(splitEnd[2]).intValue())
            return false;
        return true;
    }

    /**
     * 是否是手机号码
     *
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str) {
        Pattern pattern = Pattern.compile("(^0\\d{2,3}-\\d{5,9}|\\d{11}$)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 从当前时间 前取5年 后取5年
     *
     * @return
     */
    public static List<String> createYears() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        ArrayList<String> years = new ArrayList<>();
        for (int i = year - 4; i < year + 6; i++) {
            years.add(i + "");
        }
        return years;
    }

    public static List<String> createMonths() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add((i < 10 ? "0" : "") + i);
        }
        return list;
    }

    public static List<String> createDays(String yearString, String monthString) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(yearString), Integer.parseInt(monthString) - 1, 1);
        c.roll(Calendar.DATE, false);
        return d(1, c.get(Calendar.DATE));
    }

    public static List<String> createHours() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            list.add(i + "");
        }
        return list;
    }

    public static List<String> createMinutes() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            list.add(i + "");
        }
        return list;
    }

    public static String getTableName(Class clz, String method) {
        return clz.getSimpleName() + "$" + method;
    }

    public static List<Integer> createWeeks() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 打开文件
     * @param file
     */
    public static void openFile(File file){

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //设置intent的Action属性
        intent.setAction(Intent.ACTION_VIEW);
        //获取文件file的MIME类型
        String type = getMIMEType(file);
        //设置intent的data和Type属性。
        intent.setDataAndType(/*uri*/Uri.fromFile(file), type);
        //跳转
        MyApplication.getContext().startActivity(intent);

    }

    /**
     * 根据文件后缀名获得对应的MIME类型。
     * @param file
     */
    private static String getMIMEType(File file) {

        String type="*/*";
        String fName = file.getName();
        //获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if(dotIndex < 0){
            return type;
        }
        /* 获取文件的后缀名 */
        String end=fName.substring(dotIndex,fName.length()).toLowerCase();
        if(end.equals(""))return type;
        //在MIME和文件类型的匹配表中找到对应的MIME类型。
        for(int i=0;i<MIME_MapTable.length;i++){ //MIME_MapTable??在这里你一定有疑问，这个MIME_MapTable是什么？
            if(end.equals(MIME_MapTable[i][0]))
                type = MIME_MapTable[i][1];
        }
        return type;
    }
    private static final String[][] MIME_MapTable={
            //{后缀名， MIME类型}
            {".3gp",    "video/3gpp"},
            {".apk",    "application/vnd.android.package-archive"},
            {".asf",    "video/x-ms-asf"},
            {".avi",    "video/x-msvideo"},
            {".bin",    "application/octet-stream"},
            {".bmp",    "image/bmp"},
            {".c",  "text/plain"},
            {".class",  "application/octet-stream"},
            {".conf",   "text/plain"},
            {".cpp",    "text/plain"},
            {".doc",    "application/msword"},
            {".docx",   "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
            {".xls",    "application/vnd.ms-excel"},
            {".xlsx",   "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".exe",    "application/octet-stream"},
            {".gif",    "image/gif"},
            {".gtar",   "application/x-gtar"},
            {".gz", "application/x-gzip"},
            {".h",  "text/plain"},
            {".htm",    "text/html"},
            {".html",   "text/html"},
            {".jar",    "application/java-archive"},
            {".java",   "text/plain"},
            {".jpeg",   "image/jpeg"},
            {".jpg",    "image/jpeg"},
            {".js", "application/x-javascript"},
            {".log",    "text/plain"},
            {".m3u",    "audio/x-mpegurl"},
            {".m4a",    "audio/mp4a-latm"},
            {".m4b",    "audio/mp4a-latm"},
            {".m4p",    "audio/mp4a-latm"},
            {".m4u",    "video/vnd.mpegurl"},
            {".m4v",    "video/x-m4v"},
            {".mov",    "video/quicktime"},
            {".mp2",    "audio/x-mpeg"},
            {".mp3",    "audio/x-mpeg"},
            {".mp4",    "video/mp4"},
            {".mpc",    "application/vnd.mpohun.certificate"},
            {".mpe",    "video/mpeg"},
            {".mpeg",   "video/mpeg"},
            {".mpg",    "video/mpeg"},
            {".mpg4",   "video/mp4"},
            {".mpga",   "audio/mpeg"},
            {".msg",    "application/vnd.ms-outlook"},
            {".ogg",    "audio/ogg"},
            {".pdf",    "application/pdf"},
            {".png",    "image/png"},
            {".pps",    "application/vnd.ms-powerpoint"},
            {".ppt",    "application/vnd.ms-powerpoint"},
            {".pptx",   "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".prop",   "text/plain"},
            {".rc", "text/plain"},
            {".rmvb",   "audio/x-pn-realaudio"},
            {".rtf",    "application/rtf"},
            {".sh", "text/plain"},
            {".tar",    "application/x-tar"},
            {".tgz",    "application/x-compressed"},
            {".txt",    "text/plain"},
            {".wav",    "audio/x-wav"},
            {".wma",    "audio/x-ms-wma"},
            {".wmv",    "audio/x-ms-wmv"},
            {".wps",    "application/vnd.ms-works"},
            {".xml",    "text/plain"},
            {".z",  "application/x-compress"},
            {".zip",    "application/x-zip-compressed"},
            {"",        "*/*"}
    };

    /**
     * 获取的是下标
     */
    public static int getCurrentMonthPosition() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getCurrentDayPosition() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1;
    }

    public static int getCurrentHourPosition() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    public static int getCurrentMinutePosition() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }


    /**
     * 将数字传化为集合，并且补充0
     *
     * @param startNum 数字起点
     * @param count    数字个数
     * @return
     */
    private static List<String> d(int startNum, int count) {
        String[] values = new String[count];
        for (int i = startNum; i < startNum + count; i++) {
            String tempValue = (i < 10 ? "0" : "") + i;
            values[i - startNum] = tempValue;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        return list;
    }


}
