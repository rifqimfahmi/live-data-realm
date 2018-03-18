package com.rifqimfahmi.livedataexample.di.component

import com.rifqimfahmi.livedataexample.data.DataManager
import com.rifqimfahmi.livedataexample.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class
))

interface ApplicationComponent {
    fun getDataManager() : DataManager
}