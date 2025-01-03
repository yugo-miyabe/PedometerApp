package jp.yuyuyu.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "step_master_table")
data class StepEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "step")
    val step: Int,
    @ColumnInfo(name = "date")
    val date: String
)
