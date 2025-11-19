package com.example.snapshotStateListWeather.data.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DBMigrator {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE weather ADD COLUMN name TEXT NOT NULL DEFAULT ''")
        }
    }


}