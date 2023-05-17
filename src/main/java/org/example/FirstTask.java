package org.example;

import java.util.Arrays;

public class FirstTask {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, -5, -5, -1, 0, 1, 5, 5, 1, 2, 3};

        int minElement = numbers[0];
        int maxElement = numbers[0];

        int indexOfMinElement = 0;
        int indexOfMaxElement = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minElement) {
                minElement = numbers[i];
                indexOfMinElement = i;
            }
            if (numbers[i] >= maxElement) {
                maxElement = numbers[i];
                indexOfMaxElement = i;
            }
        }


        System.out.println(Arrays.toString(numbers));
        int wh;//fol
        int srez;
        for (int i = indexOfMinElement+1; i < (indexOfMaxElement/2)+indexOfMinElement; i++) {

            srez = indexOfMaxElement-i;
            wh = numbers[indexOfMinElement+srez];
            numbers[indexOfMinElement+srez] = numbers[i];
            numbers[i] = wh;


        }


        System.out.println(Arrays.toString(numbers));
    }
}