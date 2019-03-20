package com.example.formacao;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class CameraTest {

    // IntentsTestRule is an extension of ActivityTestRule. IntentsTestRule sets up Espresso-Intents
    // before each Test is executed to allow stubbing and validation of intents.
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void validateCamera(){
        // Create a bitmap we can use for our simulated camera image
        Bitmap image = BitmapFactory.decodeResource(
                InstrumentationRegistry.getTargetContext().getResources(),
                R.mipmap.ic_launcher);

        // Build a result to return from the Camera app
        Intent resultData = new Intent();
        resultData.putExtra("data", image);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        // Stub out the Camera. When an intent is sent to the Camera, this tells Espresso to respond
        // with the ActivityResult we just created
        intending(toPackage("com.android.camera2")).respondWith(result);

        //Click the button
        onView(withId(R.id.cameraBtn)).perform(click());

        // Also validate that an intent resolving to the "camera" activity has been sent out by our app
        intended(toPackage("com.android.camera2"));
    }
}