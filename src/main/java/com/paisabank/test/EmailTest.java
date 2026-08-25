package com.paisabank.test;

import com.paisabank.util.EmailUtil;

public class EmailTest {

    public static void main(String[] args) {

        EmailUtil emailUtil = new EmailUtil();

        String result = emailUtil.sendOTP("dakshbaid9168@gmail.com");

        System.out.println("Result: " + result);
    }
}