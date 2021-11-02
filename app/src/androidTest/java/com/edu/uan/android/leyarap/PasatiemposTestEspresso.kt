package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.edu.uan.android.leyarap.salud.SaludActivity
import org.junit.Rule
import org.junit.Test

class PasatiemposTestEspresso {

    @get:Rule
    var mActivityRule: ActivityScenarioRule<SaludActivity?>? = ActivityScenarioRule (
        SaludActivity::class.java)

    @Test
    fun pruebaBotonCrear() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_crearlista_salud)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_crear_evento_salud))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_crear_evento_salud)))
    }
    @Test
    fun creacionlista(){
        Espresso.onView(ViewMatchers.withId(R.id.edit_nombre_salud))
            .perform(ViewActions.typeText("Test_Pasatiempos"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edit_nombre_salud))
            .check(ViewAssertions.matches(ViewMatchers.withText("Test_Pasatiempos")))
        Espresso.onView(ViewMatchers.withId(R.id.btn_crear_salud)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_salud))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_salud)))
    }
}