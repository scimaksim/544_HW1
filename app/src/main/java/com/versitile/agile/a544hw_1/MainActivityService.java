package com.versitile.agile.a544hw_1;

import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;

/**
 * Created by adam on 9/2/17.
 */

public class MainActivityService implements IMainActivityService {

    String mInitialInput;
    ISort mSortUtility;

    public MainActivityService(String initialInput, ISort sortUtility) {
        mInitialInput = initialInput;
        mSortUtility = sortUtility;
    }

    public String getInitialInput() {
        return mInitialInput;
    }

    public String transformInput() throws RuntimeException {

        validateInputOnlyContainsIntegers();

        int[] inputIntegers = convertInputToIntArray();

        validateLengthOfInput(inputIntegers);

//        int[] sortedIntegers = mSortUtility.sortIntegers(inputIntegers);
        mSortUtility.sortIntegers(inputIntegers);

        return createReadableOutput(mSortUtility.getSortStages());
    }

    /**
     * convert a given string into an array of integers
     *
     * @return {@link int[]}
     */
    private int[] convertInputToIntArray() throws RuntimeException {

        char[] inputCharacters = mInitialInput.toCharArray();

        int[] intArray = new int[inputCharacters.length];

        for(int i = 0; i < inputCharacters.length; i++ ) {
            intArray[i] = Character.getNumericValue(inputCharacters[i]);
        }

        return intArray;
    }

    /**
     * for a given array add any necessary style and finally convert to a string
     *
     * @param outputObject
     * @return a formatted string ready to add to the view
     */
    private String createReadableOutput(ArrayList<int[]> outputObject) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < outputObject.size(); j++) {
            int[] outputArray = outputObject.get(j);

            for (int k = 0; k < outputArray.length; k++) {
                sb.append(outputArray[k]);

                if (j != outputArray.length -1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }

        return sb.toString();
    }

    /**
     * Ensures that given input string contains only numbers 0-9
     *
     * @throws RuntimeException if above condition is not true
     */
    private void validateInputOnlyContainsIntegers() throws RuntimeException {

        if (!mInitialInput.matches("[0-9]+")) {

            throw new RuntimeException("Only numbers 0-9 allowed.");
        }
    }

    private void validateLengthOfInput(int[] input) throws RuntimeException {
        if (input.length < 2 || input.length > 8) {

            throw new RuntimeException("Input must be more than 2 but less than 9 integers.");
        }
    }
}
