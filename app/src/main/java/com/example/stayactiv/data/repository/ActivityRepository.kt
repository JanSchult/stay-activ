package com.example.stayactiv.data.repository

import com.example.stayactiv.data.local.ActivityDao
import com.example.stayactiv.data.model.ActivityItem
import kotlinx.coroutines.flow.Flow

class ActivityRepository(
    private val dao: ActivityDao
) {

    fun getAllActivities(): Flow<List<ActivityItem>> =
        dao.getAllActivities()

    suspend fun insert(activity: ActivityItem) =
        dao.insertActivity(activity)

    suspend fun getById(id: String): Flow<ActivityItem?> =
        dao.getActivityById(id)
    suspend fun getCount(): Int = dao.count()
}
