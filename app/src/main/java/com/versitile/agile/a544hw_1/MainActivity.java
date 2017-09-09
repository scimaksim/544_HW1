package com.versitile.agile.a544hw_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mSortedListDisplayBox;
    TextView mErrorTextBox;
    TextView mNumberInput;

    public static TextView mIntermediateArray;


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
        mIntermediateArray = (TextView) findViewById(R.id.intermText);


        mSortButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {

        // Clear out old text
        mErrorTextBox.setText("");
        mSortedListDisplayBox.setText("");

        // Set up object which handles all the logic
        MainActivityService service = new MainActivityService(mNumberInput.getText().toString(), bubbleSort);

        // Display stuff
        try {
            mSortedListDisplayBox.setText(service.transformInput());
            //mIntermediateArray.append(ISwap);

            // Hide the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mSortButton.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        } catch (RuntimeException e) {
            mErrorTextBox.setText(e.getMessage());
        }

    }
}
