package com.edu.uan.android.leyarap.estadoAnimo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.edu.uan.android.leyarap.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_estado_animo.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import com.github.mikephil.charting.data.BarData

import com.github.mikephil.charting.data.BarDataSet

import com.github.mikephil.charting.data.BarEntry





class EstadoAnimo : AppCompatActivity() {
    //var barChart: BarChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estado_animo)
        val font = Typeface.createFromAsset(assets, "fonts/moon.otf")
        val datos: Intent = intent
        val data = datos?.getFloatExtra("dataestado", 3f)
        txt_estadoAnimo.typeface = font

        var barChart: BarChart? = findViewById(R.id.barchart)
        var visitors = ArrayList<BarEntry>()
/*        visitors.add(BarEntry(2016f, data))
        visitors.add(BarEntry(2015f, data))
        visitors.add(BarEntry(2016f, data))
        visitors.add(BarEntry(2017f, data))
        visitors.add(BarEntry(2018f, data))
        visitors.add(BarEntry(2019f, data))
        visitors.add(BarEntry(2020f, data))*/
        val dateTime = Calendar.getInstance().time
        val dateTimeAsLong = dateTime.time
        visitors.add(BarEntry(1f, 2f))
        visitors.add(BarEntry(2f, 5f))
        visitors.add(BarEntry(3f, 3f))
        visitors.add(BarEntry(4f, 4f))
        visitors.add(BarEntry(5f, 5f))
        visitors.add(BarEntry(6f, 3f))
        visitors.add(BarEntry(7f, 1f))


        var barDataSet = BarDataSet(visitors, "visitors")
        barDataSet.setColors(Color.rgb(61, 165, 255), Color.rgb(23, 197, 255));
        barDataSet.valueTextColor = Color.rgb(61, 165, 255)
        barDataSet.setValueTextSize(16f);

        var barData = BarData(barDataSet)

        barChart?.setFitBars(true)
        barChart?.data = barData
        barChart?.setBackgroundColor(Color.rgb(251, 217, 220))
        barChart?.description?.text = "Estado de animo"
        barChart?.animateY(2000)

    }


/*    companion object{
        private const val CHART_label = "DAY_CHART"
    }

    private val dayData = mutableListOf<Entry>()
    private val _lineDataSet = MutableLiveData(LineDataSet(dayData, CHART_label))
    val lineDataSet: LiveData<LineDataSet> = _lineDataSet

    init {
        dayData.add(Entry(0f,5f))
        dayData.add(Entry(1f,4f))
        dayData.add(Entry(2f,7f))
        dayData.add(Entry(3f,8f))
        dayData.add(Entry(4f,10f))
        dayData.add(Entry(5f,7f))
        dayData.add(Entry(6f,3f))
        dayData.add(Entry(7f,6f))
        dayData.add(Entry(8f,5f))
        dayData.add(Entry(9f,8f))
        _lineDataSet.value = LineDataSet(dayData, CHART_label)
    }*/
}