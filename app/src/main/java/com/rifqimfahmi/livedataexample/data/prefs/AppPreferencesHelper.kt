package com.rifqimfahmi.livedataexample.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.rifqimfahmi.livedataexample.di.ApplicationContext
import com.rifqimfahmi.livedataexample.di.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(@ApplicationContext context: Context,
                                               @PreferenceInfo prefName: String)
    : PreferencesHelper {

    val mSharedPreferences: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)


}