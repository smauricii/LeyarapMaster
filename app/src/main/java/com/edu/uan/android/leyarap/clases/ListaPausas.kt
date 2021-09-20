package com.edu.uan.android.leyarap.clases

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Listaitem")
class ListaPausas(
    val titulo:String,
    val diaHora:String,
    val imagen:Int,
    @PrimaryKey(autoGenerate = true)
    var idLista:Int =0
) :Serializable