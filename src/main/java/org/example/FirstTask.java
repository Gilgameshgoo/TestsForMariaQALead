package org.example;

import java.util.Arrays;

public class FirstTask {

    public static void main(String[] args) {
        int[] numbers = {};

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
        int start = 0;
        int end = 0;

        if(indexOfMaxElement<indexOfMinElement){start = indexOfMaxElement; end = indexOfMinElement;}
        if(indexOfMaxElement>indexOfMinElement){start = indexOfMinElement; end = indexOfMaxElement;}

        if(start!=end) {
            int[] slice = getSliceOfArray(numbers, start + 1, end);

            slice = reverse(slice);
            System.out.println(Arrays.toString(slice));

            System.out.println(Arrays.toString(numbers));
            insertSliceOfArray(numbers, slice, start + 1);
            System.out.println(Arrays.toString(numbers));
        }
    }

    public static int[]   reverse(int[] array){
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            tempArray[i] = array[array.length-i-1];
        }
        return tempArray;

    }

    public static int[] getSliceOfArray(int[] arr, int start, int end)
    {

        int[] slice = new int[end - start];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }

        return slice;
    }

    public static void insertSliceOfArray(int[] arr,int[] slice, int start)
    {
        for (int i = 0; i < slice.length; i++) {
            arr[start + i] = slice[i];
        }

    }}
