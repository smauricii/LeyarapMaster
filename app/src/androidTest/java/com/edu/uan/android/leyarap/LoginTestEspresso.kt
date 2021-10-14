///////////////////////////////////////////////////////////////////
package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class LoginTestEspresso {

    @get:Rule
    var mActivityRule: ActivityScenarioRule<LoginActicity?>? = ActivityScenarioRule (LoginActicity::class.java)

    @Test
    fun registro(){
        onView(ViewMatchers.withId(R.id.editCorreo))
            .perform(typeText("sebastianmauricio73@gmail.com"), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.editPassword))
            .perform(typeText("123456"), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.editCorreo))
            .check(matches(withText("sebastianmauricio73@gmail.com")))
        onView(ViewMatchers.withId(R.id.editPassword))
            .check(matches(withText("123456")))
    }
}