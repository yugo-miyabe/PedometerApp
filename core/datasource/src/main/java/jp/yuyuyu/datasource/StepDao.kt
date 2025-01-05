package jp.yuyuyu.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StepDao {

    @Insert
    suspend fun insert(stepEntity: StepEntity)

    @Update
    suspend fun update(stepEntity: StepEntity)

    @Query("SELECT * FROM step_master_table WHERE :date Limit 1")
    suspend fun getStepToday(date: String): StepEntity?

    @Delete
    suspend fun delete(stepEntity: StepEntity)
}
