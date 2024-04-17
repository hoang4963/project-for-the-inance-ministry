package com.its.xoso.utils;

import com.google.gson.Gson;
import org.apache.logging.log4j.util.Strings;

import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

public class StringUtil {

    private final static Gson gson = new Gson();

    public static String buildJson(Object t) {
        return gson.toJson(t);
    }

    static String strDigits = "0123456789abcdefghijklmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";


    public static String removeSpecCharacter(String input) {
        if (Strings.isEmpty(input)) return "";
        input = toNonUnicode(input);
        input = removeSpecialCharacters(input);
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static String randomString(int size) {
        return randomString(strDigits, size);
    }

    private static final Random random = new SecureRandom();

    public static String randomString(String digits, int size) {
        StringBuilder passBuilder = new StringBuilder();
        passBuilder.setLength(0);
        int tableSize = digits.length();
        for (int i = 0; i < size; ++i) {
            passBuilder.append(digits.charAt(random.nextInt(tableSize)));
        }
        return passBuilder.toString();
    }

    public static String toNonUnicode(String str) {
        str = str.replace("Đ", "D");
        str = str.replace("đ", "d");
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        return normalized;
    }

    public static String removeSpecialCharacters(String input) {
        return input.replaceAll("[.,\\p{P}\\p{S}]", " ");
    }

    public static boolean isEmptyOrBlank(String value) {
        if (value == null || "".equals(value.trim())) {
            return true;
        }
        return false;
    }

    public static float scaleRate(float scale, float scaleSize) {
        return scaleSize / scale;
    }

    public static boolean isDate(String dateStr) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.compile(regex).matcher(dateStr).matches();
    }

}

