package com.versitile.agile.a544hw_1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.versitile.agile.a544hw_1", appContext.getPackageName());
    }

    @Ignore
    @Test
    public void verifyOnlyIntegersCanBeImputed() {

    }

    @Ignore
    @Test
    public void verifyErrorIsThrownWhenNumberLargerThanEight() {

    }

    @Ignore
    @Test
    public void verifyErrorIsThrownWhenNumberSmallerThanTwo() {

    }

    @Ignore
    @Test
    public void verifyArrayIsFormattedCorrectly() {

    }
}
