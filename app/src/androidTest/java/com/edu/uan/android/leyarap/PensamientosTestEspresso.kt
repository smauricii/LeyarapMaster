package com.edu.uan.android.leyarap

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.edu.uan.android.leyarap.pensamientos.PensamientosActivity
import org.junit.Rule
import org.junit.Test

class PensamientosTestEspresso {

    @get:Rule
    var mActivityRule: ActivityScenarioRule<PensamientosActivity?>? = ActivityScenarioRule (
        PensamientosActivity::class.java)

    @Test
    fun pruebaBotonCrear() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_crearlista_pensamientos)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_crear_evento))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_crear_evento)))
    }
    @Test
    fun creacionlista(){
        Espresso.onView(ViewMatchers.withId(R.id.txt_nombre_pensamientos))
            .perform(ViewActions.typeText("Test_Pensamientos"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edit_descripcion))
            .perform(ViewActions.typeText("Hola esto es un test de pensamientos."), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edit_nombre_salud))
            .check(ViewAssertions.matches(ViewMatchers.withText("Test_Pasatiempos")))
        Espresso.onView(ViewMatchers.withId(R.id.edit_descripcion))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hola esto es un test de pensamientos.")))
        Espresso.onView(ViewMatchers.withId(R.id.btn_crear_pensamientos)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_pensamientos))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.txt_pensamientos)))
    }
}