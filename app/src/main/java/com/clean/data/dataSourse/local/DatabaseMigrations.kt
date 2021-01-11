package com.clean.data.dataSourse.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.clean.data.models.ProductEntity

object DatabaseMigrations {
    const val DB_VERSION = 1

    val MIGRATIONS: Array<Migration>
        get() = arrayOf<Migration>(
            migrations()
        )

    private fun migrations(): Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${ProductEntity.TABLE_NAME} ADD COLUMN body TEXT")
        }
    }
}
