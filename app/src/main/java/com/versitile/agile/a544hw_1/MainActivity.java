package com.versitile.agile.a544hw_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mSortedListDisplayBox;
    TextView mErrorTextBox;
    TextView mNumberInput;
    Button mSortButton;
    ISort bubbleSort = new BubbleSort();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSortedListDisplayBox = (TextView) findViewById(R.id.sortedListDisplayBox);
        mErrorTextBox = (TextView) findViewById(R.id.errorText);
        mNumberInput = (TextView) findViewById(R.id.numberInput);
        mSortButton = (Button) findViewById(R.id.sortButton);

        mSortButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {

        // Clear out old text
        mErrorTextBox.setText("");
        mSortedListDisplayBox.setText("");

        // Hide the keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mSortButton.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

        String input = mNumberInput.getText().toString();

        try {
            validateInputOnlyContainsIntegers(input);
        }
        catch (RuntimeException e) {
            mErrorTextBox.setText("Only numbers 0-9 allowed.");
            return;
        }

        int[] inputIntegers = convertInputToIntArray(mNumberInput.getText().toString());

        try {
            validateLengthOfInput(inputIntegers);
        }
        catch (RuntimeException e) {
            mErrorTextBox.setText("Input must be more than 2 but less than 9 integers.");
            return;
        }

        int[] sortedIntegers = bubbleSort.sortIntegers(inputIntegers);

        // TODO: think about creating a POJO which can hold each step of the sorting process and format them as necessary(red indexes).
        String formattedOutput = createReadableOutput(sortedIntegers);

        mSortedListDisplayBox.setText(formattedOutput);
    }

    /**
     * Ensures that given input string contains only numbers 0-9
     *
     * @param input
     * @throws RuntimeException if above condition is not true
     */
    private void validateInputOnlyContainsIntegers(String input) throws RuntimeException {

        if (!input.matches("[0-9]+")) {

            //TODO: customize the message here, or use a more specific exception
            throw new RuntimeException();
        }
    }

    private void validateLengthOfInput(int[] input) throws RuntimeException {
        if (input.length < 2 || input.length > 8) {

            //TODO: customize the message here, or use a more specific exception
            throw new RuntimeException();
        }
    }

    /**
     * convert a given string into an array of integers
     *
     * @param input
     * @return {@link int[]}
     */
    private int[] convertInputToIntArray(String input) throws RuntimeException {

        char[] inputCharacters = input.toCharArray();

        int[] intArray = new int[inputCharacters.length];

        for(int i = 0; i < inputCharacters.length; i++ ) {
            intArray[i] = Character.getNumericValue(inputCharacters[i]);
        }

        return intArray;
    }

    /**
     * for a given array add any necessary style and finally convert to a string
     *
     * @param outputArray
     * @return a formatted string ready to add to the view
     */
    private String createReadableOutput(int[] outputArray) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < outputArray.length; j++) {
            sb.append(outputArray[j]);

            if (j != outputArray.length -1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
