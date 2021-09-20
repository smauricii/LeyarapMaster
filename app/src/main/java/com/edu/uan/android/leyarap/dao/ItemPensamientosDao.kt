package com.edu.uan.android.leyarap.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edu.uan.android.leyarap.clases.ListaPensamientos

@Dao
interface ItemPensamientosDao {

    @Query("SELECT * FROM listapensamientos")
    fun getAll(): LiveData<List<ListaPensamientos>>

    @Query("SELECT * FROM listapensamientos WHERE idPensamientos= :id" )
    fun get(id:Int):LiveData<ListaPensamientos>

    @Insert
    fun insertAll(vararg itemListaPensamientos:ListaPensamientos)

    @Update
    fun update(itemListaPensamientos:ListaPensamientos)

    @Delete
    fun delete(itemListaPensamientos:ListaPensamientos)

}