package avila.daniel.ui.testing.util


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId

fun Int.view(): ViewInteraction = onView(withId(this))
fun Int.touch(): ViewInteraction = this.view().perform(click())

fun ViewInteraction.checkText(text: String): ViewInteraction = this.check(ViewAssertions.matches(ViewMatchers.withText(text)))