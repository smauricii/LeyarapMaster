package com.edu.uan.android.leyarap.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edu.uan.android.leyarap.clases.ListaPausas

@Dao
interface ItemPausaDao {

    @Query("SELECT * FROM Listaitem")
    fun getAll(): LiveData<List<ListaPausas>>

    @Query("SELECT * FROM Listaitem WHERE idLista = :id")
    fun get(id:Int): LiveData<ListaPausas>

    @Insert
    fun insertAll(vararg  itemlista: ListaPausas)

    @Update
    fun update(itemLista: ListaPausas)

    @Delete
    fun delete(itemLista: ListaPausas)
}