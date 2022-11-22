package com.g3c1.oasis_android.di.module

import com.g3c1.oasis_android.feature_menu.data.data_source_impl.MenuDataSourceImpl
import com.g3c1.oasis_android.feature_menu.data.data_source_impl.PurchaseDataSourceImpl
import com.g3c1.oasis_android.feature_menu.domain.repository.MenuRepository
import com.g3c1.oasis_android.feature_menu.domain.repository.PurchaseRepository
import com.g3c1.oasis_android.feature_menu.domain.repository_impl.MenuRepositoryImpl
import com.g3c1.oasis_android.feature_menu.domain.repository_impl.PurchaseRepositoryImpl
import com.g3c1.oasis_android.feature_receipt.data.datasource_impl.ReceiptDataSourceImpl
import com.g3c1.oasis_android.feature_receipt.data.repository_impl.ReceiptRepositoryImpl
import com.g3c1.oasis_android.feature_receipt.domain.datasource.ReceiptDataSource
import com.g3c1.oasis_android.feature_receipt.domain.repository.ReceiptRepository
import com.g3c1.oasis_android.feature_seat.data.data_source_impl.SeatDataSourceImpl
import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import com.g3c1.oasis_android.feature_seat.domain.repository_impl.SeatRepositoryImpl
import com.g3c1.oasis_android.feature_select_store.data.datasourceimpl.StoreDataSourceImpl
import com.g3c1.oasis_android.feature_select_store.data.repositoryimpl.StoreRepositoryImpl
import com.g3c1.oasis_android.feature_select_store.domain.repository.StoreRepository
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
    fun provideSeatRepository(dataSource: SeatDataSourceImpl): SeatRepository =
        SeatRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideMenuRepository(dataSource: MenuDataSourceImpl): MenuRepository =
        MenuRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun providePurchaseRepository(dataSource: PurchaseDataSourceImpl): PurchaseRepository =
        PurchaseRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideStoreRepository(dataSource: StoreDataSourceImpl): StoreRepository =
        StoreRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideReceiptRepository(dataSource: ReceiptDataSourceImpl): ReceiptRepository =
        ReceiptRepositoryImpl(dataSource)
}