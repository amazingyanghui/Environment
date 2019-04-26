package com.tengdi.environmentalprotectionint.modules.utils;

import com.tengdi.userauthenuuid.modules.auth.shiro.jwt.UserUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class ApiUtils {
    public static SysUserEntity getUserByToken(HttpServletRequest request) {
        String token = UserUtils.getToken(request);
        SysUserEntity sysUserEntity = new SysUserEntity();

        if (StringUtils.isEmpty(token)) {
            return sysUserEntity;
        }
        Map<String, String> map = UserUtils.getPoyload(token);
        sysUserEntity.setUserId(map.get("userId"));
        sysUserEntity.setDeptId(map.get("userDeptId"));
        return sysUserEntity;
    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    // a integer to xx:xx:xx
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + "分" + unitFormat(second)+ "秒";
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + "小时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr =  Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    /**
     * 将A,B,C,D,E,F,G,H 转为数组下标
     * @param answer
     * @return
     */
    public static String getAnswerIndex(String answer) {
        String answerOptions = "";
        // 将题目答案A,B,C转为下标
        for (String option : answer.split(",")) {
            int index = Arrays.binarySearch(ApiConstant.ANSWER_OPTIONS, option);
            if (index > -1) {
                answerOptions += index + ",";
            }
        }
        answerOptions = answerOptions.equals("")?"":answerOptions.substring(0,answerOptions.length()-1);
        return answerOptions;
    }

    /**
     * 将下标转为A,B,C,D,E,F,G,H选项
     * @param answer
     * @return
     */
    public static String getAnswerItem(String answer) {
        String answerOptions = "";
        // 将题目答案A,B,C转为下标
        for (String option : answer.split(",")) {
                answerOptions += ApiConstant.ANSWER_OPTIONS[Integer.valueOf(option)] + ",";
        }
        answerOptions = answerOptions.equals("")?"":answerOptions.substring(0,answerOptions.length()-1);
        return answerOptions;
    }


    public static void main(String[] args) throws Exception {
//        String token = "438b703216654845b2f72a3a060460d0da43f46f49676e384cf266182966f611";
//        String userId = token.substring(0,32);
//        String key = token.substring(33,token.length()-1);
//        System.out.println(userId);
//        System.out.println(key);
        System.out.println(getAnswerItem("0,1,2"));
    }

}
