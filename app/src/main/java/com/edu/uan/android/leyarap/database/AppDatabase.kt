package com.edu.uan.android.leyarap.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edu.uan.android.leyarap.clases.ListaPausas
import com.edu.uan.android.leyarap.dao.ItemPausaDao

//cambiar la version cuando vaya a agregar la otra lista para que no genere problemas
@Database(entities = [ListaPausas::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemLista(): ItemPausaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_databaselist"
                ).build()

                INSTANCE = instance

                return instance
            }

        }
    }
}