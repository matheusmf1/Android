package com.example.formacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class FragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void isFragDisplayed(){
        onView(withId(R.id.fragmentBtn)).perform(click());
        onView(withId(R.id.fragText)).check(matches(withText("Hello World in Fragment")));
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}