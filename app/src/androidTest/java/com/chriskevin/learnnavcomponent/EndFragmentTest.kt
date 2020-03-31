package com.chriskevin.learnnavcomponent

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndFragmentTest {

    @Test
    fun testNavigationToStartFragment() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        ).apply {
            setGraph(R.navigation.nav_graph)
            setCurrentDestination(R.id.endFragment)
        }

        val fragmentArgs = bundleOf("data" to "test")
        val endFragmentScenario = launchFragmentInContainer<EndFragment>(fragmentArgs)

        endFragmentScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.data)).check(matches(withText("test")))
        onView(withId(R.id.return_button)).check(matches(isDisplayed()))
        onView(withId(R.id.return_button)).perform(click())

        val currentDestination = navController.backStack.last()
        assertThat(currentDestination.destination.id).isEqualTo(R.id.startFragment)
    }
}