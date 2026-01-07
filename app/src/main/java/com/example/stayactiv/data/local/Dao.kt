package com.example.stayactiv.data.local

import androidx.room.*
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.util.ActivityCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    // -------------------------
    // Basic CRUD
    // -------------------------

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertActivity(activity: ActivityItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertActivities(activities: List<ActivityItem>)

    @Update
    suspend fun updateActivity(activity: ActivityItem)

    @Delete
    suspend fun deleteActivity(activity: ActivityItem)

    // -------------------------
    // Queries
    // -------------------------

    @Query("SELECT * FROM activities ORDER BY title ASC")
    fun getAllActivities(): Flow<List<ActivityItem>>

    @Query("SELECT * FROM activities WHERE id = :id LIMIT 1")
    fun getActivityById(id: String): Flow<ActivityItem?>

    @Query("SELECT * FROM activities WHERE isUserCreated = 1 ORDER BY title ASC")
    fun getUserActivities(): Flow<List<ActivityItem>>

    @Query("SELECT * FROM activities WHERE isUserCreated = 0 ORDER BY title ASC")
    fun getDefaultActivities(): Flow<List<ActivityItem>>

    // -------------------------
    // Filtering
    // -------------------------

    @Query(
        """
        SELECT * FROM activities
        WHERE category = :category
        ORDER BY title ASC
    """
    )
    fun getActivitiesByCategory(category: ActivityCategory): Flow<List<ActivityItem>>

    @Query(
        """
        SELECT * FROM activities
        WHERE :isOutdoor = isOutdoor
        ORDER BY title ASC
    """
    )
    fun getActivitiesByOutdoor(isOutdoor: Boolean): Flow<List<ActivityItem>>
    @Query("SELECT COUNT(*) FROM activities")
    suspend fun count(): Int
}
