package com.edu.uan.android.leyarap.clases

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "listapensamientos")
class ListaPensamientos (
    val titulo:String,
    val descripcion:String,
    val imagen:Int,
    @PrimaryKey(autoGenerate = true)
    var idPensamientos:Int =0
):Serializable