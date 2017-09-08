package com.versitile.agile.a544hw_1;

import java.util.ArrayList;

/**
 * Created by adam on 8/29/17.
 */

public class BubbleSort implements ISort {

    private ArrayList<int[]> mSortStages = new ArrayList<>();

    public ArrayList<int[]> getSortStages() { return mSortStages; }

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

        int[] listToSortCopy = new int[listToSort.length];
        System.arraycopy(listToSort, 0, listToSortCopy, 0, listToSort.length);

        mSortStages.add(listToSortCopy);

        if ( numberOfSwaps == 0) {
            return listToSort;
        }
        else {
            sortIntegers(listToSort);
        }

        return listToSort;
    }

    private int[] swap(int value1, int value2, int index, int[] array) {

        if (value1 < value2) {
            array[index] = value2;
            array[index - 1] = value1;
        }

        return array;
    }

}
