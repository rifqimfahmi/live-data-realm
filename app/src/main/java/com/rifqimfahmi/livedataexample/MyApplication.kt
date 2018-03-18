package com.rifqimfahmi.livedataexample

import android.app.Application
import com.rifqimfahmi.livedataexample.di.component.ApplicationComponent
import com.rifqimfahmi.livedataexample.di.component.DaggerApplicationComponent
import com.rifqimfahmi.livedataexample.di.module.ApplicationModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by rifqimfahmi on 12/02/18.
 */
open class MyApplication : Application() {

    lateinit var mAppComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)

        mAppComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()


    }
}