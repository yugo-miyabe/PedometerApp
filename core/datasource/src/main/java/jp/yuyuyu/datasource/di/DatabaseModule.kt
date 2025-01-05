package jp.yuyuyu.datasource.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.yuyuyu.datasource.PedometerDatabase
import jp.yuyuyu.datasource.StepDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): PedometerDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = PedometerDatabase::class.java,
            name = "pedometer",
        ).build()
    }

    @Provides
    fun provideStepDao(pedometerDatabase: PedometerDatabase): StepDao = pedometerDatabase.StepDao()

}
