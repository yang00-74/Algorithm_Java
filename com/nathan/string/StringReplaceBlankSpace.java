package com.nathan.string;

public class StringReplaceBlankSpace {

    public static void main(String[] args) {
        String s = "888,99897, 98898";
        System.out.println(new StringReplaceBlankSpace().replaceSpace(s));
    }

    /**
     * 剑指 Offer 05
     * */
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
