package com.g3c1.oasis_android.di.module

import com.g3c1.oasis_android.feature_menu.domain.repository.MenuRepository
import com.g3c1.oasis_android.feature_menu.domain.repository.PurchaseRepository
import com.g3c1.oasis_android.feature_menu.domain.use_case.GetMenuListUseCase
import com.g3c1.oasis_android.feature_menu.domain.use_case.SendsTheOrderedFoodListUseCase
import com.g3c1.oasis_android.feature_receipt.domain.repository.ReceiptRepository
import com.g3c1.oasis_android.feature_receipt.domain.usecase.GetOrderedListByMeUseCase
import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import com.g3c1.oasis_android.feature_seat.domain.use_case.GetSeatDataUseCase
import com.g3c1.oasis_android.feature_seat.domain.use_case.PatchSeatDataUseCase
import com.g3c1.oasis_android.feature_select_store.domain.repository.StoreRepository
import com.g3c1.oasis_android.feature_select_store.domain.usecase.GetSumarizedStoreInfoUseCase
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
    fun provideSeatUseCase(repository: SeatRepository): GetSeatDataUseCase =
        GetSeatDataUseCase(repository)

    @Provides
    @Singleton
    fun provideFetchUseCase(repository: SeatRepository): PatchSeatDataUseCase =
        PatchSeatDataUseCase(repository)

    @Provides
    @Singleton
    fun provideGetUseCase(repository: MenuRepository): GetMenuListUseCase =
        GetMenuListUseCase(repository)

    @Provides
    @Singleton
    fun provideSendsTheOrderedFoodList(repository: PurchaseRepository): SendsTheOrderedFoodListUseCase =
        SendsTheOrderedFoodListUseCase(repository)

    @Provides
    @Singleton
    fun provideGetSumarizedStoreInfoUseCase(repository: StoreRepository): GetSumarizedStoreInfoUseCase =
        GetSumarizedStoreInfoUseCase(repository)

    @Provides
    @Singleton
    fun provideGetOrderedListByMe(repository: ReceiptRepository): GetOrderedListByMeUseCase =
        GetOrderedListByMeUseCase(repository)
}