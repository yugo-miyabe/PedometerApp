package jp.yuyuyu.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StepDao {

    @Insert
    suspend fun insert(stepEntity: StepEntity)

    /*
    @Query("SELECT * FROM step_master_table")
    suspend fun getStepToday(): StepEntity
    */

    @Delete
    suspend fun delete(stepEntity: StepEntity)
}
