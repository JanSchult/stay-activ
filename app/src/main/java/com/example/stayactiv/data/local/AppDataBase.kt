package com.example.stayactiv.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import  com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.util.Converters

@Database(entities = [ActivityItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class NoteDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao

    companion object {
        @Volatile
        private var Instance: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NoteDatabase::class.java, "note_database")
                    .build().also { Instance = it }
            }
        }
    }
}
