package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeTestEspreso {

    @Test
    fun pruebaBotonPausa() {
        onView(withId(R.id.btn_pausas_act)).perform(click())
        onView(withId(R.id.txt_pausa)).check(matches(withText(R.id.txt_pausa)))
    }
    @Test
    fun pruebaBotonSalud() {
        onView(withId(R.id.btn_salud_act)).perform(click())
        onView(withId(R.id.txt_salud)).check(matches(withText(R.id.txt_salud)))
    }
    @Test
    fun pruebaBotonPensamientos() {
        onView(withId(R.id.btn_pensamientos)).perform(click())
        onView(withId(R.id.txt_pensamientos)).check(matches(withText(R.id.txt_pensamientos)))
    }
    @Test
    fun pruebaBotonEstadoAnimo() {
        onView(withId(R.id.btn_estado_animo)).perform(click())
        onView(withId(R.id.txt_estadoAnimo)).check(matches(withText(R.id.txt_estadoAnimo)))
    }
}