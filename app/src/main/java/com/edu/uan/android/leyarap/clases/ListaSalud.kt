package com.edu.uan.android.leyarap.clases

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "listasalud")
class ListaSalud (val titulo:String,
                  val imagen:Int,
                  @PrimaryKey(autoGenerate = true)
                  var idListaSalud: Int =0
) :Serializable