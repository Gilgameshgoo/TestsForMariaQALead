package org.example;

import java.util.Arrays;

public class SecondTask {
    public static void main(String[] args) {
        String textSt = "abbaakk";
        String wordSt = "abbaakg";
        char[] text = textSt.toCharArray();
        char[] word = wordSt.toCharArray();

        if (text.length > 0 && word.length > 0) {
            System.out.println("Result: " + checkWord(text, word));
        }
        else
        {
            System.err.println("Make suse you have introduced valid data; Length of text is: "+text.length +", Length of word is: " + word.length);
        }

}
    public static boolean checkWord(char[] text, char[] word) {
        boolean[] usedLetters = new boolean[text.length];
        fillBoolArray(usedLetters,false);

        for(int i = 0; i< word.length; i++){
            if( !letterIsAccessible(text, usedLetters, word[i]) || !(text.length>= word.length) ){

                System.err.println("Letter: '" + word[i] +"' Is inaccessible " + " at Index: " + i);
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

    public static boolean letterIsAccessible(char[] text, boolean[] usedLetters, char letter) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] == letter && !usedLetters[i]) {
                usedLetters[i] = true;
                return true;
            }
        }
        return false;
    }
}
