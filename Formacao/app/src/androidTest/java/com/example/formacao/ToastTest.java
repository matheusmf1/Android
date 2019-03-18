package com.example.formacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Root;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import android.view.WindowManager;
import android.os.IBinder;


public class ToastTest extends TypeSafeMatcher<Root> {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;


    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
    }


    @Override
    protected boolean matchesSafely(Root root) {
        int type = root.getWindowLayoutParams().get().type;

        if (( type == WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)){
            IBinder windowsToken = root.getDecorView().getWindowToken();
            IBinder appToken = root.getDecorView().getApplicationWindowToken();
            return windowsToken == appToken;
        }
        return false;
    }

    @Test
    public void isToastDisplayed(){
        //CLICK TOAST BUTTON
        onView(withId(R.id.toastBtn)).perform(click());

//        onView(withId(R.string.toastMsg)).inRoot(new ToastTest())
//                .check(withText("Hello Hello World by Toast"));

        MainActivity activity = mActivityTestRule.getActivity();

        onView(withText(R.string.toastMsg))
                .inRoot(withDecorView(not(is(activity.getWindow().getDecorView()))))
                .check(ViewAssertions.matches(isDisplayed()));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }


    @After
    public void tearDown() {
        mActivity = null;
    }

}