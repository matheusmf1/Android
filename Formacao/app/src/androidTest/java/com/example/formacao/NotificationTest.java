package com.example.formacao;

import android.app.Instrumentation;
import android.content.Context;
import android.content.res.Resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiCollection;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

public class NotificationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;
    private UiDevice device;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
       device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void checkNotification(){
        onView(allOf(withId(R.id.notificationBtn),isDisplayed())).perform(click());

        device.wait(Until.hasObject(By.text("Title")),200);

        UiObject2 title = device.findObject(By.text("Title"));
        UiObject2 text = device.findObject(By.text("Hello World"));

        assertEquals("Title", title.getText());
        assertEquals("Hello World", text.getText());
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}