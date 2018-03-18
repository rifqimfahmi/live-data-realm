package com.rifqimfahmi.livedataexample.di.component

import com.rifqimfahmi.livedataexample.di.PerActivity
import com.rifqimfahmi.livedataexample.di.module.ActivityModule
import com.rifqimfahmi.livedataexample.ui.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)
}