package com.example.stayactiv.data.repository

import com.example.stayactiv.data.local.ActivityDao
import com.example.stayactiv.data.model.ActivityItem
import kotlinx.coroutines.flow.Flow

class ActivityRepository(
    private val dao: ActivityDao
) {

    suspend fun addActivity(activity: ActivityItem) {
        dao.insertActivity(activity)
    }

    fun getActivities(): Flow<List<ActivityItem>> =
        dao.getAllActivities()
}
