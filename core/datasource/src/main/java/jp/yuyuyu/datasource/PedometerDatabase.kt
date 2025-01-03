package jp.yuyuyu.datasource

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StepEntity::class], version = 1, exportSchema = false)
abstract class PedometerDatabase : RoomDatabase() {
    abstract fun StepDao(): StepDao
}
