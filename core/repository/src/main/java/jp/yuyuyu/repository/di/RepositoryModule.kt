package jp.yuyuyu.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.yuyuyu.datasource.StepDao
import jp.yuyuyu.repository.StepRepository
import jp.yuyuyu.repository.internal.StepRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideStepRepository(
        stepDao: StepDao
    ): StepRepository = StepRepositoryImpl(stepDao = stepDao)
}
