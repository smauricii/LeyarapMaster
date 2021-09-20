package com.edu.uan.android.leyarap.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edu.uan.android.leyarap.clases.ListaSalud
import com.edu.uan.android.leyarap.dao.ItemSaludDao

@Database(entities = [ListaSalud::class],version=1)
abstract class AppDatabaseSalud: RoomDatabase() {

    abstract fun itemListaSalud(): ItemSaludDao

    companion object{
        @Volatile
        private var INSTANCES:AppDatabaseSalud? = null
        fun getDatabase(context: Context): AppDatabaseSalud{
            val tempInstance = INSTANCES
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabaseSalud::class.java,
                    "app_databaselistsalud"
                ).build()

                INSTANCES = instance

                return instance
            }
        }
    }
}