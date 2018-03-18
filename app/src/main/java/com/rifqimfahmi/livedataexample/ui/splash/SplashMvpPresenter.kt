package com.rifqimfahmi.livedataexample.ui.splash

import com.rifqimfahmi.livedataexample.di.PerActivity
import com.rifqimfahmi.livedataexample.ui.base.MvpPresenter

@PerActivity
interface SplashMvpPresenter<V: SplashMvpView> : MvpPresenter<V>{

}