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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.protobuf.Int64Value
import kotlinx.android.synthetic.main.activity_eleccion.*


class EstadoAnimo : AppCompatActivity() {
    //var barChart: BarChart? = null
    private val db = FirebaseFirestore.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estado_animo)
        val font = Typeface.createFromAsset(assets, "fonts/moon.otf")
        val datos: Intent = intent
        val data = datos?.getFloatExtra("dataestado", 3f)
        txt_estadoAnimo.typeface = font
        val bundle = intent.extras
        val email = bundle?.getString("email")
        var dataMonday: Long;
        var dataTuesday: Double;
        var dataWednesday: Long;
        var dataThursday: Double;
        var dataFriday: Long;
        var dataSaturday: Long;
        var dataSunday: Long;



        db.collection("datosUsuario").document(email+"Monday").get().
        addOnSuccessListener {
            dataMonday= it.get("Animo") as Long
            if(dataMonday==null){
                dataMonday=0;
            var barChart: BarChart? = findViewById(R.id.barchart)
            var visitors = ArrayList<BarEntry>()
            visitors.add(BarEntry(2016f, dataMonday.toFloat()))
            var barDataSet = BarDataSet(visitors, "visitors")
            barDataSet.setColors(Color.rgb(61, 165, 255), Color.rgb(23, 197, 255));
            barDataSet.valueTextColor = Color.rgb(61, 165, 255);
            barDataSet.setValueTextSize(16f);

            var barData = BarData(barDataSet)

            barChart?.setFitBars(true)
            barChart?.data = barData
            barChart?.description?.text = "ejemplo de la datta"
            barChart?.animateY(2000)
        }
        }

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