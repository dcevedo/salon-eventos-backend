package com.ciclo3.saloneventos.utils;

import java.util.regex.Pattern;

public class Utility {
    
    public static boolean emailPatternMatches(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
          .matcher(emailAddress)
          .matches();
    }

    public static boolean onlyLettersMatches(String str) {
        System.out.println(str);
        return Pattern.compile("^[A-Za-z\\s]*$")
          .matcher(str)
          .matches();
    }
}
