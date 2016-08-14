package be.appfoundry.accessibility;

import android.support.test.espresso.contrib.AccessibilityChecks;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AccessibilityEspressoTest {

    @Rule
    public ActivityTestRule<BadExample> activityRule = new ActivityTestRule<>(
        BadExample.class);

    @Before
    public void setUp() {
        AccessibilityChecks.enable();
    }

    @Test
    public void testShareButton_shouldSendIntent() {
        onView(withId(R.id.imageButton1)).perform(click());

        // assertions
        onView(withId(R.id.imageButton3)).check(matches(isDisplayed()));
    }
}
