package com.edu.uan.android.leyarap.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edu.uan.android.leyarap.clases.ListaSalud

@Dao
interface ItemSaludDao {

    @Query("SELECT * FROM listasalud")
    fun getAll(): LiveData<List<ListaSalud>>

    @Query("SELECT * FROM listasalud WHERE idListaSalud = :id")
    fun get(id:Int):LiveData<ListaSalud>

    @Insert
    fun insetAll(vararg  itemListaSalud: ListaSalud)

    @Update
    fun update(itemListaSalud: ListaSalud)

    @Delete
    fun delete(itemListaSalud: ListaSalud)


}