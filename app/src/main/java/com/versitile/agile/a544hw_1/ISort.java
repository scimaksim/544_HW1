package com.versitile.agile.a544hw_1;

import java.util.ArrayList;

/**
 * Created by adam on 8/29/17.
 */

public interface ISort {
    /**
     * For a given list of integers, sort in ascending order
     *
     * @param listToSort {@link int[]} an array of integers
     * @return the given array, sorted
     */
    public int[] sortIntegers(int[] listToSort);

    public ArrayList<int[]> getSortStages();
}
