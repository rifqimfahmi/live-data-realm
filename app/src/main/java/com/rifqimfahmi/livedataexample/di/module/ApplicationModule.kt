package com.rifqimfahmi.livedataexample.di.module

import android.app.Application
import android.content.Context
import com.rifqimfahmi.livedataexample.data.AppDataManager
import com.rifqimfahmi.livedataexample.data.DataManager
import com.rifqimfahmi.livedataexample.data.prefs.AppPreferencesHelper
import com.rifqimfahmi.livedataexample.data.prefs.PreferencesHelper
import com.rifqimfahmi.livedataexample.di.ApplicationContext
import com.rifqimfahmi.livedataexample.di.PreferenceInfo
import com.rifqimfahmi.livedataexample.util.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (application: Application) {

    val mApplication : Application = application

    @Provides
    @ApplicationContext
    fun provideContext(): Context = mApplication.applicationContext

    @Provides
    fun provideApplication(): Application = mApplication

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager) : DataManager = appDataManager

    /*
        provide sharedPreferences need
     */

    @Provides
    @PreferenceInfo
    fun providePreferencesFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper) : PreferencesHelper = appPreferencesHelper
}