package com.versitile.agile.a544hw_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView sortedListDisplayBox;
    TextView numberInput;
    Button sortButton;
    ISort bubbleSort = new BubbleSort();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sortedListDisplayBox = (TextView) findViewById(R.id.sortedListDisplayBox);
        numberInput = (TextView) findViewById(R.id.numberInput);
        sortButton = (Button) findViewById(R.id.sortButton);


        sortButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {


        // Get value input by user
        String input = numberInput.getText().toString();

        char[] inputCharacters = input.toCharArray();
        int[] intArray = new int[inputCharacters.length];

        for(int i = 0; i < inputCharacters.length; i++ ) {
            intArray[i] = Character.getNumericValue(inputCharacters[i]);
        }

        // TODO: validate input
            // TODO; Create exceptions for each invalid type of input

        // TODO: Sort the list

        // Hide the keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(sortButton.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

        // TODO: create POJO to pass to view, which can eventually hold everything needed by the view.
        int[] sortedArray = bubbleSort.sortIntegers(intArray);

        StringBuilder sb = new StringBuilder();

        // TODO: do all this better.
        for (int j = 0; j < sortedArray.length; j++) {
            sb.append(sortedArray[j]);
        }

        // TODO: output sorted list
        sortedListDisplayBox.setText(sb.toString());
    }

    //TODO: Remove logic from onClick
}
