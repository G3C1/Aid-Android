package com.g3c1.oasis_android.di

import android.app.Application
import com.g3c1.oasis_android.feature_select_store.data.utils.SearialNumberManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OasisApp : Application() {
    private lateinit var searialNumberManager: SearialNumberManager

    companion object {
        private lateinit var oasisApp: OasisApp
        fun getInstance(): OasisApp = oasisApp
    }

    override fun onCreate() {
        super.onCreate()
        oasisApp = this
        searialNumberManager = SearialNumberManager(this)
    }

    fun getSearialNumberManager(): SearialNumberManager = searialNumberManager
}