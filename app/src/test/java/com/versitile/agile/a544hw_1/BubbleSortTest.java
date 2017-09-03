package com.versitile.agile.a544hw_1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Test bubble sort algorithm with an array of random numbers from 0 - 9
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BubbleSortTest {

    private ISort bubbleSort;

    @Before
    public void setup()
    {
        bubbleSort = new BubbleSort();
    }


    @Test
    public void bubbleSortReturnsCorrectlySortedList() {
        int[] initialList = new int[5];

        initialList[0] = createRandomInt();
        initialList[1] = createRandomInt();
        initialList[2] = createRandomInt();
        initialList[3] = createRandomInt();
        initialList[4] = createRandomInt();

        int[] sortedList = bubbleSort.sortIntegers(initialList);

        assertThat("index 0 value is less than or equal to index 1 value", (sortedList[0] <= sortedList[1]), is(true));
        assertThat("index 1 value is less than or equal index 2 value", (sortedList[1] <= sortedList[2]), is(true));
        assertThat("index 2 value is less than or equal index 3 value", (sortedList[2] <= sortedList[3]), is(true));
        assertThat("index 3 value is less than or equal index 4 value", (sortedList[3] <= sortedList[4]), is(true));
    }

    @Test
    public void bubbleSortNegativeTest() {
        int[] initialList = new int[3];

        initialList[0] = 5;
        initialList[1] = 3;
        initialList[2] = 1;

        int[] sortedList = bubbleSort.sortIntegers(initialList);

        assertThat("index 0 is not equal to 5", sortedList[0], is(not(5)));
        assertThat("index 2 is not equal to 1", sortedList[2], is(not(1)));
    }

    private int createRandomInt()
    {
        return (int)Math.floor(Math.random() * 10);
    }
}