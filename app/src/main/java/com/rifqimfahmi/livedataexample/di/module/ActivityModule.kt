package com.rifqimfahmi.livedataexample.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.rifqimfahmi.livedataexample.di.ActivityContext
import com.rifqimfahmi.livedataexample.di.PerActivity
import com.rifqimfahmi.livedataexample.ui.splash.SplashMvpPresenter
import com.rifqimfahmi.livedataexample.ui.splash.SplashMvpView
import com.rifqimfahmi.livedataexample.ui.splash.SplashPresenter
import com.rifqimfahmi.livedataexample.util.rx.AppSchedulerProvider
import com.rifqimfahmi.livedataexample.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@Module
class ActivityModule constructor(appCompatActivity: AppCompatActivity) {
    val mAppCompatActivity: AppCompatActivity = appCompatActivity

    @Provides
    @ActivityContext
    fun provideContext(): Context = mAppCompatActivity

    @Provides
    fun provideActivity(): AppCompatActivity = mAppCompatActivity

    @Provides
    fun provideScheduler(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @PerActivity
    fun provideSplashMvpPresenter(presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> = presenter
}