package com.nathan.string;

public class StringReplace {

    public static void main(String[] args) {
        String s = "888,99897,98898";
        StringBuffer s1 = new StringBuffer(s);
        System.out.println(new StringReplace().replaceSpace(s1));
    }

    public String replaceSpace(StringBuffer s) {
        if (s == null) {
            return null;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                s.replace(i, i + 1, "%20");
            }
        }
        String s0 = s.toString();
        return s0;
    }
}
