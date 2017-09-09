package com.versitile.agile.a544hw_1;

import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by adam on 8/29/17.
 */


public class BubbleSort implements ISort {

    public int[] sortIntegers(int[] listToSort) {
        int numberOfSwaps = 0;

        for (int i = listToSort.length -1; i > 0; i--) {
            int currentIndex = listToSort[i];
            int prevIndex = listToSort[i-1];
            if(currentIndex < prevIndex) {
                numberOfSwaps ++;
                swap(currentIndex, prevIndex, i, listToSort);

            }
        }

        if ( numberOfSwaps == 0) {
            return listToSort;
        }
        else {
            sortIntegers(listToSort);
        }

        return listToSort;
    }

    public int[] swap(int value1, int value2, int index, int[] array) {

        if (value1 < value2) {
            array[index] = value2;
            array[index - 1] = value1;
        }
        MainActivity.mIntermediateArray.append(Arrays.toString(array) + "\n");

        return array;
    }
}
