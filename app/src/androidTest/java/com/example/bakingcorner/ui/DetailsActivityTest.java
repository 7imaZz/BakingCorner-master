package com.example.bakingcorner.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.bakingcorner.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailsActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void detailsActivityTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tv_cake), withText("Nutella Pie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rv_cakes),
                                        0),
                                0)));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.tv_ingredients), withText("2.0 CUP's Graham Cracker crumbs\n\n6.0 TBLSP's unsalted butter, melted\n\n0.5 CUP's granulated sugar\n\n1.5 TSP's salt\n\n5.0 TBLSP's vanilla\n\n1.0 K's Nutella or other chocolate-hazelnut spread\n\n500.0 G's Mascapone Cheese(room temperature)\n\n1.0 CUP's heavy cream(cold)\n\n4.0 OZ's cream cheese(softened)\n\n"),
                        childAtPosition(
                                allOf(withId(R.id.fragment),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("2.0 CUP's Graham Cracker crumbs  6.0 TBLSP's unsalted butter, melted  0.5 CUP's granulated sugar  1.5 TSP's salt  5.0 TBLSP's vanilla  1.0 K's Nutella or other chocolate-hazelnut spread  500.0 G's Mascapone Cheese(room temperature)  1.0 CUP's heavy cream(cold)  4.0 OZ's cream cheese(softened)  ")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_ingredients), withText("2.0 CUP's Graham Cracker crumbs\n\n6.0 TBLSP's unsalted butter, melted\n\n0.5 CUP's granulated sugar\n\n1.5 TSP's salt\n\n5.0 TBLSP's vanilla\n\n1.0 K's Nutella or other chocolate-hazelnut spread\n\n500.0 G's Mascapone Cheese(room temperature)\n\n1.0 CUP's heavy cream(cold)\n\n4.0 OZ's cream cheese(softened)\n\n"),
                        childAtPosition(
                                allOf(withId(R.id.fragment),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.tv_steps), withText("Steps"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Steps")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.tv_steps), withText("Steps"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("Steps")));

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.tv_steps), withText("Steps"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.tv_steps), withText("Steps"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.tv_steps), withText("Steps"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView4.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(android.R.id.text1), withText("Recipe Introduction"),
                        childAtPosition(
                                allOf(withId(R.id.lv_steps),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView6 = onView(
                allOf(withId(android.R.id.text1), withText("Recipe Introduction"),
                        childAtPosition(
                                allOf(withId(R.id.lv_steps),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView6.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.text1), withText("Finish filling prep"),
                        childAtPosition(
                                allOf(withId(R.id.lv_steps),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                5),
                        isDisplayed()));
        textView7.check(matches(withText("Finish filling prep")));

        ViewInteraction textView8 = onView(
                allOf(withId(android.R.id.text1), withText("Finish filling prep"),
                        childAtPosition(
                                allOf(withId(R.id.lv_steps),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                5),
                        isDisplayed()));
        textView8.check(matches(withText("Finish filling prep")));

        DataInteraction appCompatTextView5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lv_steps),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)))
                .atPosition(0);
        appCompatTextView5.perform(click());

        ViewInteraction view = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.exo_content_frame),
                                childAtPosition(
                                        withId(R.id.video),
                                        1)),
                        0),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.btn_back_to_steps),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.tv_desc), withText("Recipe Introduction\n\nRecipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView9.check(matches(withText("Recipe Introduction  Recipe Introduction")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.tv_desc), withText("Recipe Introduction\n\nRecipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(isDisplayed()));

        ViewInteraction view2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.exo_content_frame),
                                childAtPosition(
                                        withId(R.id.video),
                                        1)),
                        0),
                        isDisplayed()));
        view2.check(matches(isDisplayed()));

        ViewInteraction view3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.exo_content_frame),
                                childAtPosition(
                                        withId(R.id.video),
                                        1)),
                        0),
                        isDisplayed()));
        view3.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
