package com.wzb.test;

import com.wzb.util.VerifyUtils;

/**
 * @Author Administrator
 * @Date 2022/3/9 0009 11:16
 */
public class VerifyTest {

    public static void main(String[] args){
        String email ="2533****81@qq.com";
        String phone ="182****3094";
        String idNumber ="412723199910******";

        boolean isEmail = VerifyUtils.isEmail(email);
        boolean isPhone = VerifyUtils.isChinaPhoneLegal(phone);
        boolean isIdNumber = VerifyUtils.isIDNumber(idNumber);

        System.out.println("邮箱信息是否正确"+isEmail);
        System.out.println("手机号信息是否正确"+isPhone);
        System.out.println("身份证信息是否正确"+isIdNumber);


    }


}
