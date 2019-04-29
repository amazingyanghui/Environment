package com.tengdi.environmentalprotectionint.modules.common.utils;

import com.tengdi.core.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static double[] StringToInt(String[] arrs){
        double[] doubles = new double[arrs.length];
        for(int i=0;i<arrs.length;i++){
            doubles[i] = Double.valueOf(arrs[i]);
        }
        return doubles;
    }
    public static String getFormatSize(double size) {
        double kiloByte = size/1024;
        if(kiloByte < 1) {
            return size + "Byte(s)";
        }

        double megaByte = kiloByte/1024;
        if(megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte/1024;
        if(gigaByte < 1) {
            BigDecimal result2  = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte/1024;
        if(teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }
    public static String subStringByDate(String str){
        if(StringUtils.isNotBlank(str)){
            str=str.substring(0,str.indexOf(" "));
        }
        return str;
    }

    public static String dateFormat(String oldDate){
        if(StringUtils.isNotBlank(oldDate)){
            Date newDate=DateUtils.stringToDate(oldDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year=sdf.format(newDate);
            int month=newDate.getMonth()+1;
            int day=newDate.getDate();
            oldDate= year+"/"+month+"/"+day;
        }
        return oldDate;
    }

    public static String subStringDate(String oldDate){
        if(StringUtils.isNotBlank(oldDate)){
            if(oldDate.lastIndexOf(".")!=-1){
                oldDate=oldDate.substring(0,oldDate.lastIndexOf("."));
            }
        }
        return oldDate;
    }

    public static void delFile(String path){
        File file=new File(path);
        if(file.exists()&&file.isFile())
            file.delete();
    }
}
