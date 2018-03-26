package com.calvinnor.accomplish.data_layer

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.calvinnor.accomplish.model.TaskModel

/**
 * Interface to manipulate the database.
 * Make sure to add the corresponding Runnables for each method to {@link TaskHandler} for easy access.
 */
@Dao
interface TaskDao {

    @Query("SELECT * from ${TASK_TABLE_NAME}")
    fun getTasks(): List<TaskModel>

    @Insert(onConflict = REPLACE)
    fun insert(taskModel: TaskModel)

    @Update
    fun updateTask(taskModel: TaskModel)

    @Delete
    fun deleteTasks(vararg taskModels: TaskModel)

    @Query("DELETE FROM ${TASK_TABLE_NAME}")
    fun deleteAllTasks()

}