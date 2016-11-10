package com.brainacademy.lesson1_3_1;

public class Main {

    public static void main(String[] args) {
        char charVal = 'a';
        charVal = 10;
        charVal = '\u0123';
        //charVal = '10';

        byte byteVal;
        byteVal = 1;
        byteVal = 07;//восьмеричненько
        byteVal = 0x7;//hex
        byteVal = 'a';//будет взят код символа
        System.out.println(byteVal);

        byteVal = (byte) charVal;
        charVal = (char) byteVal;


        short shortVal = 0;
        shortVal = 10;
        shortVal = byteVal;
        byteVal = (byte) shortVal;

        float floatVal;
        floatVal = 1;
        floatVal = 1.5f;

        floatVal = byteVal;
        System.out.println(floatVal);

        floatVal = 300;
        byteVal = (byte) floatVal;
        System.out.println(byteVal);


        double doubleVal;
        doubleVal = 1;
        doubleVal = 9.5;

        doubleVal = byteVal;
        doubleVal = floatVal;

        floatVal = (float) doubleVal;
        byteVal = (byte) doubleVal;

        doubleVal = 123_456.987_765;
        //doubleVal = 123_.987_765; Так нельзя
        //doubleVal = 123._987_765;
        System.out.println(doubleVal);

        int intVal;
        intVal = 10;
        intVal = 0b1000;
        intVal = 07123;
        intVal = 0x123AF;


        byteVal = (byte) intVal;
        floatVal = intVal;
        doubleVal = intVal;

        intVal = byteVal;
        intVal = (int) floatVal;
        intVal = (int) doubleVal;
        System.out.println(intVal);

        long longVal = 100;
        longVal = intVal;
        System.out.println(longVal);

        intVal = (int) longVal;


        Integer intObj = new Integer(20);
        intObj = Integer.valueOf("20");
        intObj = Integer.valueOf(20);
        intObj = 20;

        intObj = intVal;
        intVal = intObj;

        intObj = null;

        intObj = new Integer(10);
        Integer intObj1 = new Integer(10);

        System.out.println(intObj == intObj1);
        System.out.println(intObj.equals(intObj1));

        boolean bool = false;
        bool = true;
        bool = Boolean.valueOf("false");

        Boolean boolObj = new Boolean(false);
        boolObj = bool;
        bool = boolObj;

        boolObj  = null;



        System.out.println("Show all: " + intVal + ", " + bool + ", " + longVal + ", " + Integer.toHexString(intVal));
    }
}
