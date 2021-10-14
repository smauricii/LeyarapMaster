package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InicioTestEspresso {
    @get:Rule
    var mActivityRule: ActivityScenarioRule<InicioActicity?>? = ActivityScenarioRule (InicioActicity::class.java)

    @Test
    fun btnComenzar(){
        onView(withId(R.id.btntengocuenta)).perform(click())
        onView(withId(R.id.textarriba)).check(matches(withText("Bienvenido")))
    }
}