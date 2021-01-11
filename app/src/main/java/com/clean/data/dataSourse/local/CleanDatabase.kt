package com.clean.data.dataSourse.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clean.data.dataSourse.local.dao.ProductDao
import com.clean.data.models.ProductEntity

@Database(entities = [ProductEntity::class], version = DatabaseMigrations.DB_VERSION)
abstract class CleanDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao

    companion object {
        const val DB_NAME = "basalam_database"

        @Volatile
        private var INSTANCE: CleanDatabase? = null

        fun getInstance(context: Context): CleanDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, CleanDatabase::class.java, DB_NAME
                ).addMigrations(*DatabaseMigrations.MIGRATIONS).build()

                INSTANCE = instance
                return instance
            }
        }

    }
}