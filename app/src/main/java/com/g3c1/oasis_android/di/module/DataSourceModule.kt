package com.g3c1.oasis_android.di.module

import com.g3c1.oasis_android.feature_menu.data.data_source_impl.MenuDataSourceImpl
import com.g3c1.oasis_android.feature_seat.data.data_source_impl.SeatDataSourceImpl
import com.g3c1.oasis_android.feature_select_store.data.datasourceimpl.StoreDataSourceImpl
import com.g3c1.oasis_android.remote.api.FoodApi
import com.g3c1.oasis_android.remote.api.SeatApi
import com.g3c1.oasis_android.remote.api.StoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideSeatDataSource(service: SeatApi) = SeatDataSourceImpl(service = service)

    @Provides
    @Singleton
    fun provideMenuDataSource(service: FoodApi) = MenuDataSourceImpl(service = service)

    @Provides
    @Singleton
    fun provideStoreDataSource(api: StoreApi) = StoreDataSourceImpl(api = api)
}