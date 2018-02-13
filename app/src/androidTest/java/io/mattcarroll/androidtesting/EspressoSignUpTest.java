package io.mattcarroll.androidtesting;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.mattcarroll.androidtesting.signup.SignUpActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EspressoSignUpTest extends EspressoSignUpPage{

    @Rule
    public ActivityTestRule<SignUpActivity> activityRule
            = new ActivityTestRule<>(
            SignUpActivity.class,
            true,     // initialTouchMode
            true);   // launchActivity. False to customize the intent

    /**
     * Resource ID guide:
     *
     * Personal Info screen
     *    • CollectPersonalInfoFragment.java
     *    • fragment_collect_personal_info.xml
     *
     *  First name              R.id.edittext_first_name
     *  Last name               R.id.edittext_last_name
     *  Address line 1          R.id.edittext_address_line_1
     *  Address line 2          R.id.edittext_address_line_2
     *  City                    R.id.edittext_address_city
     *  State                   R.id.edittext_address_state
     *  ZIP                     R.id.edittext_address_zip
     *  Next button             R.id.button_next
     *
     * Collect Interests screen
     *    • CollectInterestsFragment.java
     *    • fragment_collect_interests.xml
     *
     *  Next button             R.id.button_next
     *  Error dialog body       R.string.dialog_select_interests_body
     *
     * Credentials screen
     *    • SelectCredentialsFragment.java
     *    • fragment_select_credentials.xml
     *
     *  Email                   R.id.autocompletetextview_email
     *  Password                R.id.edittext_password
     *  Sign Up! button         R.id.button_next
     */

    @Test
    public void userSignUpHappyPath() {
        // TODO implement this test

        // Fill in personal info

        scrollToAndTypeText(R.id.edittext_first_name, "Sergey");
        scrollToAndTypeText(R.id.edittext_last_name, "Odintsov");
        scrollToAndTypeText(R.id.edittext_address_line_1, "199 Fremont St");
        scrollToAndTypeText(R.id.edittext_address_line_2, "Fitbit office");
        scrollToAndTypeText(R.id.edittext_address_city, "San Francisco");
        scrollToAndTypeText(R.id.edittext_address_state, "CA");
        scrollToAndTypeText(R.id.edittext_address_zip, "94105");

        scrollToAndTapOnNextButton();

        assertLandingOnTheCorrectActivity("Programming");
    }

    @Test
    public void     requiredFieldsAreRequired() {
        // TODO implement this test

        hideKeyboard();
        scrollToAndTapOnNextButton();

        assertErrorWithTextIsShownOnAField(R.id.edittext_first_name, R.string.input_error_required);
        assertErrorWithTextIsShownOnAField(R.id.edittext_last_name, R.string.input_error_required);
        assertErrorWithTextIsShownOnAField(R.id.edittext_address_line_1, R.string.input_error_required);
        assertErrorWithTextIsShownOnAField(R.id.edittext_address_city, R.string.input_error_required);
        assertErrorWithTextIsShownOnAField(R.id.edittext_address_state, R.string.input_error_required);
        assertErrorWithTextIsShownOnAField(R.id.edittext_address_zip, R.string.input_error_required);
    }

    @Test
    public void atLeastOneInterestMustBeSelectedToContinue() {
        // TODO implement this test

        // Fill in personal info

        scrollToAndTypeText(R.id.edittext_first_name, "Sergey");
        scrollToAndTypeText(R.id.edittext_last_name, "Odintsov");
        scrollToAndTypeText(R.id.edittext_address_line_1, "199 Fremont St");
        scrollToAndTypeText(R.id.edittext_address_line_2, "Fitbit office");
        scrollToAndTypeText(R.id.edittext_address_city, "San Francisco");
        scrollToAndTypeText(R.id.edittext_address_state, "CA");
        scrollToAndTypeText(R.id.edittext_address_zip, "94105");

        scrollToAndTapOnNextButton();

        // tap next button
        tapNext();

        assertLandingOnTheCorrectActivity("Please select at least 1 interest.");
    }
}
