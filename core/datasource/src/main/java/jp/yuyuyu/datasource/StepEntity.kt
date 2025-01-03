package jp.yuyuyu.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.Date

@Entity(
    tableName = "step_master"
)
data class StepEntity(
    @ColumnInfo(name = "step")
    val step: Int,
    @ColumnInfo(name = "date")
    val date: Date
)
