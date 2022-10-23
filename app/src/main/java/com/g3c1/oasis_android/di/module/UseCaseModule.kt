package com.g3c1.oasis_android.di.module

import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import com.g3c1.oasis_android.feature_seat.domain.use_case.GetSeatDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideSeatUseCase(repository: SeatRepository): GetSeatDataUseCase = GetSeatDataUseCase(repository)
}