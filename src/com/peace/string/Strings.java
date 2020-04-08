package com.peace.string;

public class Strings {

    public static void main(String[] args) {

        // 19 chars, from index 0 to 18
        String a = "123456 112233445566";

        // size
        System.out.println("Size: " + a.length()); // 19

        // index of char
        System.out.println("Index of a: " + a.indexOf('a')); // -1
        System.out.println("Index of a: " + a.indexOf('1')); // 0
        System.out.println("Index of a: " + a.indexOf('2')); // 1

        // last index of char
        System.out.println("Index of a: " + a.lastIndexOf('6')); // 18
        System.out.println("Index of a: " + a.lastIndexOf('1')); // 8

        // last index of string
        System.out.println("Index of a: " + a.lastIndexOf("234")); // 1
        System.out.println("Index of a: " + a.lastIndexOf("2X4")); // -1

        // index of char starting from index 2
        System.out.println("Index of 1 form 2: " + a.indexOf('1', 2)); // 7

        // charAt
        // System.out.println("Char at -1: " + a.charAt(-1)); // exception
        System.out.println("Char at 0: " + a.charAt(0)); // '1'
        // System.out.println("Char at length: " + a.charAt(a.length())); // exception
        System.out.println("Char at length - 1: " + a.charAt(a.length() - 1)); // '6'
        System.out.println("Char at: " + a.charAt(a.indexOf('1', 2))); // '1'

        // hashcode
        System.out.println((int) a.hashCode());

        // equals
        System.out.println("abc".equals("ABC")); // false
        System.out.println("abc".equals("abc")); // true

        // contains
        System.out.println("xyzabcxyz".contains("abc")); // true
        System.out.println("xyzabcxyz".contains("Abc")); // false

        // substring(beginIndex)
        System.out.println("Substring(1): " + "ABCDE".substring(1)); // BCDE

        // substring(beginIndex, endIndex) >>> [beginIndex, endIndex)
        System.out.println("0123456789ABCDEF".substring(1, 4)); // 123

        // startsWith
        System.out.println("abcde".startsWith("abcd")); // true
    }

}