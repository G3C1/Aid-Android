package com.g3c1.oasis_android.di.module

import com.g3c1.oasis_android.feature_seat.data.data_source_impl.SeatDataSourceImpl
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatDataSource
import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import com.g3c1.oasis_android.feature_seat.domain.repository_impl.SeatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSeatRepository(dataSource: SeatDataSourceImpl): SeatRepository
        = SeatRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideMenuRepository(dataSource: MenuDataSourceImpl): MenuRepository =
        MenuRepositoryImpl(dataSource)
}