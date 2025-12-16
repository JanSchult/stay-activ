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

abstract class ActivityDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao

    companion object {
        @Volatile
        private var Instance: ActivityDatabase? = null

        fun getDatabase(context: Context): ActivityDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ActivityDatabase::class.java, "activity_database")
                    .build().also { Instance = it }
            }
        }
    }
}
