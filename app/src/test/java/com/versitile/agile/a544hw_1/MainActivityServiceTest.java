package com.versitile.agile.a544hw_1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by adam on 9/2/17.
 */

public class MainActivityServiceTest {

    ISort mSortMethod;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() { mSortMethod = new BubbleSort(); }

    @Test
    public void verifyErrorIsThrownWhenInputContainsNonNumbers() {

        IMainActivityService service = new MainActivityService("3.12", mSortMethod);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Only numbers 0-9 allowed.");
        service.transformInput();
    }

    @Test
    public void verifyErrorIsThrownWhenInputIsTooShort() {
        IMainActivityService service = new MainActivityService("3", mSortMethod);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Input must be more than 2 but less than 9 integers.");
        service.transformInput();
    }

    @Test
    public void verifyErrorIsThrownWhenInputIsTooLong() {
        IMainActivityService service = new MainActivityService("1234567897", mSortMethod);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Input must be more than 2 but less than 9 integers.");
        service.transformInput();
    }

    @Test
    public void verifyOutputIsAsExpectd() {

        String expectedOutput = "3 4 5 7 8";
        IMainActivityService service = new MainActivityService("43587", mSortMethod);

        String actualOutput = service.transformInput();

        assertThat("actualOutput matches expectedOutput", actualOutput, is(equalTo(expectedOutput)));
    }
}
