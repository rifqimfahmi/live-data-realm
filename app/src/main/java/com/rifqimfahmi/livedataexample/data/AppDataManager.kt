package com.rifqimfahmi.livedataexample.data

import android.content.Context
import com.rifqimfahmi.livedataexample.data.prefs.PreferencesHelper
import com.rifqimfahmi.livedataexample.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

    @Singleton
    class AppDataManager @Inject constructor(@ApplicationContext context: Context,
                                             preferencesHelper: PreferencesHelper)
        : DataManager {

        val mContext: Context = context
        val mPreferencesHelper: PreferencesHelper = preferencesHelper

    }