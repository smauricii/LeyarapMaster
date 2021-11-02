package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import org.junit.Rule
import org.junit.Test

class PausaTestEspresso {


    @get:Rule
    var mActivityRule: ActivityScenarioRule<PausasActivasActivity?>? = ActivityScenarioRule (PausasActivasActivity::class.java)

    @Test
    fun pruebaBotonCrear() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_crearlista)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_crear_evento))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_crear_evento)))
    }
    @Test
    fun creacionlista(){
        Espresso.onView(ViewMatchers.withId(R.id.txt_nombre))
            .perform(ViewActions.typeText("Test"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.txt_nombre))
            .check(ViewAssertions.matches(ViewMatchers.withText("Test")))
        Espresso.onView(ViewMatchers.withId(R.id.btn_crear)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_pausa))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_pausa)))
    }
}