package org.example;

import java.util.Arrays;

public class SecondTask {
    public static void main(String[] args) {
        // text = "aaabbkk";
        char[] text = {'a','a','a','b','b','k','k'};
        char[] word = {'a','b','b','a','a','k','g'};
        //String word = "abbaakk";

        if(text.length>0 && word.length>0){
            System.out.println("Result: " + checkW(text,word));}

    }

    public static boolean checkW(char[] text, char[] word) {
        boolean[] usedLetters = new boolean[text.length];
        fillBoolArray(usedLetters,false);

        for(int i = 0; i< word.length; i++){
            if( !letterIsAccesable(text, usedLetters, word[i]) || !(text.length>= word.length) ){

                System.err.println("Letter: " + word[i] + " Index: " + i);
                return false;
            }

        }
        System.out.println(Arrays.toString(usedLetters));
        return true;

    }

    public static void fillBoolArray(boolean[] arr, boolean value) {
        for (int x = 0; x < arr.length; x++) {
            arr[x] = value;
        }
    }

    public static boolean letterIsAccesable(char[] text, boolean[] usedLetters, char letter) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] == letter && !usedLetters[i]) {
                usedLetters[i] = true;
                return true;
            }
        }
        return false;
    }
}
