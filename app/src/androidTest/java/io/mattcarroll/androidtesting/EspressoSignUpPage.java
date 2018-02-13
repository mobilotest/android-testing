package io.mattcarroll.androidtesting;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.content.res.Resources;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sergio1tsov on 2/5/18.
 */

public class EspressoSignUpPage {

    public Resources resources;

    @Before
    public void setup() {
        // getTargetContext() operates on the application under test
        // getContext() operates on the test APK context
        resources = InstrumentationRegistry.getTargetContext().getResources();
    }

    public void hideKeyboard() {
        Espresso.closeSoftKeyboard();
    }

    public void scrollToAndTypeText(int fieldIdentifier, String userTextInput) {
        onView(withId(fieldIdentifier))
                .perform(scrollTo(), typeText(userTextInput));
    }

    public void scrollToAndTapOnNextButton() {
        onView(withId(R.id.button_next))
                .perform(scrollTo(), click());
    }

    public void tapNext() {
        onView(withId(R.id.button_next))
                .perform(click());
    }

    public void assertLandingOnTheCorrectActivity(String someText) {
        onView(withText(someText)).check(matches(isDisplayed()));
    }

    public void assertErrorWithTextIsShownOnAField(int fieldIdentifier, int errorIdentifier){
        onView(withId(fieldIdentifier)).check(matches(hasErrorText(resources.getString(errorIdentifier))));
    }
}
