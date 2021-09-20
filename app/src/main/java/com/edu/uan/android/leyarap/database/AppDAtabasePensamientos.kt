package com.edu.uan.android.leyarap.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edu.uan.android.leyarap.clases.ListaPensamientos
import com.edu.uan.android.leyarap.dao.ItemPensamientosDao

@Database(entities = [ListaPensamientos::class], version = 1)
abstract class AppDAtabasePensamientos : RoomDatabase() {

    abstract fun itemListaPensamientos(): ItemPensamientosDao


    companion object {
        @Volatile
        private var INSTANCE: AppDAtabasePensamientos? = null

        fun getDatabase(context: Context): AppDAtabasePensamientos {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder (
                    context.applicationContext,
                    AppDAtabasePensamientos::class.java,
                    "app_databasepensamientos"
                    ).build()

                INSTANCE = instance
                return instance

            }
        }
    }
}