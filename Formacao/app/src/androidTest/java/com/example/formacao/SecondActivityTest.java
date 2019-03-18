package com.example.formacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class SecondActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void isActivityDisplayed(){
        onView(withId(R.id.activityBtn)).perform(click());
        // AFTER CLICKING THE BUTTON, A NEW ACTIVITY WILL POP UP.
        // Clicking launches a new activity that shows some text defined on XML. You don't need to do
        // anything special to handle the activity transitions. Espresso takes care of waiting for the
        // new activity to be resumed and its view hierarchy to be laid out.
        onView(withId(R.id.outraActivity)).check(matches(isDisplayed()));

        onView(withId(R.id.outraActivity)).check(matches(withText("Hello World")));
    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}